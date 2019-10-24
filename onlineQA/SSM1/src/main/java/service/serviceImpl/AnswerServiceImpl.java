package service.serviceImpl;

import mapper.AnswerMapper;
import mapper.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Answer;
import service.AnswerService;

import java.util.Date;

@Service("answerService")
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerMapper answerMapper;
    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public boolean addAnswer(Answer answer) {
        answer.setAnsDate(new Date());
        int row=answerMapper.addAnswer(answer);
        if(row==1){
            return  questionMapper.updateAnsCount(answer.getQid())==1?true:false;
        }else{
            return false;
        }
    }
}
