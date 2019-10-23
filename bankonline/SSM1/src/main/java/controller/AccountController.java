package controller;

import constant.StatusCodeConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pojo.Account;
import pojo.Transaction;
import service.AccountService;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/loginTo")
    public String loginTo(){
        return "login";
    }

    @RequestMapping("/login")
    public String login(@ModelAttribute Account account, Model model, HttpSession session){
        //代码存在冗余，有待改进
        //卡号是否存在
        boolean existsCardNo=accountService.existsCardNo(account.getCardNo());
        if(existsCardNo){
            //账号是否存在
            account=accountService.queryByCardAndPwd(account);
            if(account!=null){
                //账号是否被冻结
                if(account.getStatus()==1){
                    session.setAttribute("account",account);
                    return "main";
                }else{
                    model.addAttribute("ErrorMsg","账号已被冻结");
                }
            }else{
                model.addAttribute("ErrorMsg","密码错误");
            }
        }else{
            model.addAttribute("ErrorMsg","卡号不存在");
        }
        return "login";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("account");
        session.invalidate();
        return "redirect:login";
    }

    @RequestMapping("/balance/{id}")
    public String queryBalance(@PathVariable("id")long id,Model model){
        Double balance=accountService.queryBalance(id);
        model.addAttribute("balance",balance);
        model.addAttribute("page","balance");
        return "main";
    }

    @RequestMapping("/transferTo")
    public String transferTo(Model model){
        model.addAttribute("page","transfer");
        return "main";
    }

    @RequestMapping("/transfer")
    public String transfer(@RequestParam()String cardNo,@RequestParam()double transferAmount, HttpSession session,Model model){
        Account sourceAccount=(Account) session.getAttribute("account");
        //存储是否成功即失败的原因
        //键为成功或失败，值为失败的原因
        Map<String,Object> map=accountService.transfer(cardNo,transferAmount,sourceAccount);
        int code=(int)map.get("code");
        String msg=(String)map.get("msg");
        model.addAttribute("code",code);
        model.addAttribute("msg",msg);
        model.addAttribute("page","transfer");
        return "main";
    }

}
