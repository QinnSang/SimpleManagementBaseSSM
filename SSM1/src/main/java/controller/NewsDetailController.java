package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pojo.NewsDetail;
import service.NewsDetailService;

import java.util.List;

@Controller
@RequestMapping("/news")
public class NewsDetailController {

    @Autowired
    private NewsDetailService newsDetailService;

    @RequestMapping("/getAll")
    public String getAllNews(Model model){
        List<NewsDetail> list=newsDetailService.getALlNews();
        model.addAttribute("news",list);
        return "main";
    }

    @RequestMapping("queryNewsByName")
    public String qeuryByTitle(@RequestParam("title") String title, Model model){
        List<NewsDetail> list=newsDetailService.queryNewsByName(title);
        model.addAttribute("news",list);
        return "main";
    }

    @RequestMapping("/delete/{newsid}")
    public String deleteById(@PathVariable("newsid") int newsid, Model model){
        boolean deleteFlag=newsDetailService.deleteById(newsid);
        List<NewsDetail> list=newsDetailService.getALlNews();
        model.addAttribute("news",list);
        return "main";
    }


}
