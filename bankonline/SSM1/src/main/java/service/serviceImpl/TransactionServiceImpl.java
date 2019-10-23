package service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import dto.RecordDto;
import mapper.TransactionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Transaction;
import service.TransactionService;

import java.util.List;

@Service("transactionService")
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionMapper transactionMapper;
    /**
     * 将查询的交易记录进行分页
     * @param recordDto
     * @return
     */
    @Override
    public PageInfo<Transaction> pageTransaction(RecordDto recordDto) {
        PageHelper.startPage(recordDto.getPageNum(),recordDto.getPageSize());
        List<Transaction> list=transactionMapper.queryTransaction(recordDto);
        PageInfo<Transaction> page=new PageInfo<>(list);
        return page;
    }
}
