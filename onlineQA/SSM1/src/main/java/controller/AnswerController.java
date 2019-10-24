package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.Answer;
import pojo.Question;
import service.AnswerService;
import service.QuestionService;

import java.util.Date;

@Controller
@RequestMapping("/answer")
public class AnswerController {

    @Autowired
    private AnswerService answerService;
    @Autowired
    private QuestionService questionService;
    @RequestMapping("/add")
    public String addAnswer(@ModelAttribute Answer answer, Model model){
        boolean addFlag=answerService.addAnswer(answer);
        Question question=questionService.queryQA(answer.getQid());
        model.addAttribute("questions",question);
        return "qa";
    }
}
