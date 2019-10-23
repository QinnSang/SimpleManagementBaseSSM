package service;

import pojo.Account;
import pojo.Transaction;

import java.util.Map;

public interface AccountService {
    boolean existsCardNo(String cardNo);

    Account queryByCardAndPwd(Account account);

    Double queryBalance(long id);

    Map<String, Object> transfer(String cardNo, double transferAmount, Account sourceAccount);
}
