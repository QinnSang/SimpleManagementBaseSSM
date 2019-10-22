package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pojo.EdocCategory;
import pojo.EdocEntry;
import service.EdocCategoryService;
import service.EdocEntryService;

import java.util.List;

@Controller
@RequestMapping("/category")
public class EdocCategoryController {

    @Autowired
    private EdocEntryService entryService;
    @Autowired
    private EdocCategoryService categoryService;

    @RequestMapping("/query/categoryId")
    public String queryById(@RequestParam int id, Model model){
        List<EdocCategory> categories=categoryService.getALl();
        List<EdocEntry> list=entryService.queryByCateId(id);
        //保留查询的条件
        model.addAttribute("categoryId",id);
        model.addAttribute("entries",list);
        model.addAttribute("categories",categories);
        return "main";
    }
}
