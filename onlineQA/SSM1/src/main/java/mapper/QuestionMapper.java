package mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import pojo.Question;

import java.util.List;

@Mapper
public interface QuestionMapper {
    List<Question> queryAllQuestions();

    int addQuestion(Question question);

    Question queryQA(@Param("id") long id);

    int updateAnsCount(@Param("qid") long qid);
}
