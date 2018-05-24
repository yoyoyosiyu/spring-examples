package com.kgl1688.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/*
    这个例子演示如何处理表单数据，验证表单数据，并且通过重定向传递参数。
 */



@Controller
public class SearchController {

    @RequestMapping("/search")
    public String searchHome() {
        return "search";
    }

    @RequestMapping(value = "/postSearch", method = RequestMethod.POST)
    public String postSearch(HttpServletRequest request, RedirectAttributes redirectAttributes) {

        String keyword = request.getParameter("keyword");

        if (keyword == null || keyword == "") {

            redirectAttributes.addFlashAttribute("error", "enter keyword");
            return "redirect:search";
        }

        redirectAttributes.addAttribute("keyword", keyword);

        return "redirect:result";
    }

    // 注意这里的参数要设置默认值,否则会报告400错误Bad Request
    @RequestMapping("/result")
    public String getResult(@RequestParam(defaultValue = "") String keyword, Model model) {

        model.addAttribute("keyword", keyword);

        List<String> names = new ArrayList<>();
        names.add("red");
        names.add("green");
        names.add("blue");

        model.addAttribute("names", names);
        return "resultPage";
    }

}
