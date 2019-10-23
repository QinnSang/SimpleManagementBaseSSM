package service;

import com.github.pagehelper.PageInfo;
import dto.RecordDto;
import pojo.Transaction;

import java.util.List;

public interface TransactionService {
    PageInfo<Transaction>  pageTransaction(RecordDto recordDto);
}
