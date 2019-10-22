package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.EdocCategory;
import pojo.EdocEntry;
import service.EdocCategoryService;
import service.EdocEntryService;

import java.util.List;

@Controller
@RequestMapping("/entry")
public class EdocEntryController {

    @Autowired
    private EdocEntryService entryService;
    @Autowired
    private EdocCategoryService categoryService;

    @RequestMapping("/getAll")
    public String getAll(Model model){
        //获取所有分类
        List<EdocCategory> categories=categoryService.getALl();
        //获取所有文件
        List<EdocEntry> entries=entryService.getAll();
        model.addAttribute("categories",categories);
        model.addAttribute("entries",entries);
        return "main";
    }

    @RequestMapping("/addTo/{cateId}")
    public String addTo(@PathVariable int cateId, Model model){
        //提取分类信息
        model.addAttribute("cateId",cateId);
        return "addEdoc";
    }

    @RequestMapping("/add")
    public String addEntry(@ModelAttribute EdocEntry entry,Model model){
        boolean addFlag=entryService.addEntry(entry);
        model.addAttribute("addFlag",addFlag);
        int categoryId=entry.getEdocCategory().getId();
        //获取所有分类
        List<EdocCategory> categories=categoryService.getALl();
        //获取所有文件
        List<EdocEntry> entries=entryService.queryByCateId(categoryId);
        model.addAttribute("categories",categories);
        model.addAttribute("entries",entries);
        model.addAttribute("categoryId",categoryId);
        return "main";
    }
    @RequestMapping("/modifyTo/{entryId}")
    public String modifyTo(@PathVariable int entryId,Model model){
        EdocEntry entry=entryService.queryByEntryId(entryId);
        model.addAttribute("entry",entry);
        return "modifyEdoc";
    }

    @RequestMapping("/modify")
    public String modifyEntry(@ModelAttribute EdocEntry entry,Model model){
        boolean modifyFlag=entryService.modifyEntry(entry);
        model.addAttribute("modifyFlag",modifyFlag);
        int categoryId=entry.getEdocCategory().getId();
        //获取所有分类
        List<EdocCategory> categories=categoryService.getALl();
        //获取所有文件
        List<EdocEntry> entries=entryService.queryByCateId(categoryId);
        model.addAttribute("categories",categories);
        model.addAttribute("entries",entries);
        model.addAttribute("categoryId",categoryId);
        return "main";
    }

    @RequestMapping("/delete/{entryId}")
    public String deleteEntry(@PathVariable int entryId,Model model){
        boolean deleteFlag=entryService.deleteEntry(entryId);
        model.addAttribute("deleteFlag",deleteFlag);
        //获取所有分类
        List<EdocCategory> categories=categoryService.getALl();
        //获取所有文件
        List<EdocEntry> entries=entryService.getAll();
        model.addAttribute("categories",categories);
        model.addAttribute("entries",entries);
//        model.addAttribute("categoryId",categoryId);
        return "main";
    }
}
