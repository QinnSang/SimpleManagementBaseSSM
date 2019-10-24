package service.serviceImpl;

import mapper.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Question;
import service.QuestionService;

import java.util.List;

@Service("questionService")
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionMapper questionMapper;
    @Override
    public List<Question> queryAllQuestions() {
        return questionMapper.queryAllQuestions();
    }

    @Override
    public boolean addQuestion(Question question) {
        return questionMapper.addQuestion(question)==1?true:false;
    }

    @Override
    public Question queryQA(long id) {
        return questionMapper.queryQA(id);
    }
}
