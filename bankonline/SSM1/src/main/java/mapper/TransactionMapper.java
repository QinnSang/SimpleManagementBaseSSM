package mapper;

import dto.RecordDto;
import org.apache.ibatis.annotations.Mapper;
import pojo.Transaction;

import java.util.List;

@Mapper
public interface TransactionMapper {
    int insertRecord(Transaction transaction);

    List<Transaction> queryTransaction(RecordDto recordDto);
}
