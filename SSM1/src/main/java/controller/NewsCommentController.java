package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pojo.NewsComment;
import service.NewsCommentService;

import java.util.List;

@Controller
@RequestMapping("/comments")
public class NewsCommentController {

    @Autowired
    private NewsCommentService newsCommentService;

    @RequestMapping("/query/newsid/{newsid}")
    public String queryComment(@PathVariable int newsid, Model model){
        List<NewsComment> list=newsCommentService.queryComment(newsid);
        model.addAttribute("comments",list);
        return "comments";
    }

    @RequestMapping("/addTo/{newid}")
    public String addTo(@PathVariable("newid")int id,Model model){
        model.addAttribute("newid",id);
        return "addComment";
    }

    @RequestMapping("/add")
    public String add(@ModelAttribute NewsComment newsComment, Model model){
        Boolean flag=newsCommentService.addComment(newsComment);
        List<NewsComment> list=newsCommentService.queryComment(newsComment.getNewsDetail().getId());
        model.addAttribute("comments",list);
        return "comments";
    }
}
