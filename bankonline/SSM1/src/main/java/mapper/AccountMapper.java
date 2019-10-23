package mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import pojo.Account;

@Mapper
public interface AccountMapper {
    int queryByCardNo(@Param("cardNo") String cardNo);

    Account queryByCardAndPwd(Account account);

    Double queryBalance(@Param("id") long id);

    int queryStatus(@Param("cardNo") String cardNo);

    void updatePlusMoney(@Param("cardNo")String cardNo, @Param("transferAmount") double transferAmount);

    void updateMinusMoney(@Param("sourceAccount") Account sourceAccount, @Param("transferAmount")double transferAmount);
}
