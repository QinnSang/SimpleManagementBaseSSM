package controller;

import com.github.pagehelper.PageInfo;
import dto.RecordDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.Transaction;
import service.TransactionService;

import java.util.List;

@Controller
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @RequestMapping("/recordTo")
    public String recordTo(Model model){
        model.addAttribute("page","record");
        return "main";
    }

    @RequestMapping("/queryTransaction")
    public String queryTransaction(@ModelAttribute RecordDto recordDto,Model model){
        //对查询的数据进行分页
        PageInfo<Transaction> pageInfo=transactionService.pageTransaction(recordDto);
        //指定main.jsp内含哪一个页面
        model.addAttribute("page","record");
        //将数据放到model里
        model.addAttribute("pageInfo",pageInfo);
        return "main";
    }
}
