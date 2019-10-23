package service.serviceImpl;

import constant.StatusCodeConstant;
import jdk.net.SocketFlow;
import mapper.AccountMapper;
import mapper.TransactionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Account;
import pojo.Transaction;
import service.AccountService;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private TransactionMapper transactionMapper;
    @Override
    public boolean existsCardNo(String cardNo) {
        return accountMapper.queryByCardNo(cardNo)==1?true:false;
    }

    @Override
    public Account queryByCardAndPwd(Account account) {
        return accountMapper.queryByCardAndPwd(account);
    }

    @Override
    public Double queryBalance(long id) {
        return accountMapper.queryBalance(id);
    }

    @Override
    public Map<String, Object> transfer(String cardNo, double transferAmount, Account sourceAccount) {
        Map<String, Object> map=new HashMap<>();
        int code= StatusCodeConstant.Not_Exists;
        String msg=null;
        //判断转账卡号是否存在
        boolean flag=accountMapper.queryByCardNo(cardNo)==1?true:false;
        if(flag){
            //判断转账卡号是否被冻结
            int status=accountMapper.queryStatus(cardNo);
            if(status==1){
                //余额是否足够转账
                if(sourceAccount.getBalance()>transferAmount){
                    //目标账号+钱
                    accountMapper.updatePlusMoney(cardNo,transferAmount);
                    //源账号-钱
                    accountMapper.updateMinusMoney(sourceAccount,transferAmount);
                    //增加交易记录
                    Transaction transaction=new Transaction();
                    transaction.setCardNo(sourceAccount.getCardNo());
                    transaction.setTransactionAmount(transferAmount);
                    transaction.setTransactionDate(new Date());
                    //应该再查询一次余额，但这里直接写了
                    transaction.setBalance(sourceAccount.getBalance()-transferAmount);
                    transaction.setTransactionType("转账");
                    transaction.setRemark("我想谁转账");
                    transactionMapper.insertRecord(transaction);
                    code=StatusCodeConstant.Success;
                    msg= StatusCodeConstant.Success_MSG;
                }else{
                    code=StatusCodeConstant.LackMoney;
                    msg=StatusCodeConstant.LackMoney_MSG;
                }
            }else{
                code=StatusCodeConstant.Account_flozen;
                msg=StatusCodeConstant.Account_flozen_MSG;
            }
        }else{
            code=StatusCodeConstant.Not_Exists;
            msg=StatusCodeConstant.Not_Exists_MSG;
        }
        map.put("code",code);
        map.put("msg",msg);
        return map;
    }
}

