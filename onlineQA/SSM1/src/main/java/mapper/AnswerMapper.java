package mapper;

import org.apache.ibatis.annotations.Mapper;
import pojo.Answer;

@Mapper
public interface AnswerMapper {
    int addAnswer(Answer answer);
}
