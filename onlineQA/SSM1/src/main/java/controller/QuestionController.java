package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.Question;
import service.QuestionService;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @RequestMapping("/main")
    public String main(Model model){
        List<Question> questions=questionService.queryAllQuestions();
        model.addAttribute("questions",questions);
        return "main";
    }

    @RequestMapping("/addTo")
    public String addTo(){
        return "add";
    }

    @RequestMapping("/add")
    public String add(@ModelAttribute Question question,Model model){
        question.setLastModified(new Date());
        question.setAnswerCount(0);
        boolean flag=questionService.addQuestion(question);
        List<Question> list=questionService.queryAllQuestions();
        model.addAttribute("questions",list);
        return "redirect:main";
    }

    @RequestMapping("/query/answer/{id}")
    public String queryQA(@PathVariable long id,Model model){
        Question list=questionService.queryQA(id);
        model.addAttribute("questions",list);
        return "qa";
    }
}
