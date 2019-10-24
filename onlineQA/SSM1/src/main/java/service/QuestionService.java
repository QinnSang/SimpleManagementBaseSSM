package service;

import pojo.Question;

import java.util.List;

public interface QuestionService {
    List<Question> queryAllQuestions();

    boolean addQuestion(Question question);

    Question queryQA(long id);
}
