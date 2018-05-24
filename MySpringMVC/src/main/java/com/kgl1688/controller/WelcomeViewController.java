package com.kgl1688.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WelcomeViewController {

    /*
        演示如何获取到请求的参数，并且如何传递参数给Spring MVC的视图
        视图使用了thymeleaf, 返回的字符串会经过thymeleaf根据thymeleaf 的viewResolver映射到对应的模板文件
        这里返回welcome， 那么将会对应到 WEB-INF/thymeleaf/welcome.html模板文件
     */
    @RequestMapping(value="/welcome", method= RequestMethod.GET)
    public String Welcome(Model model, @RequestParam(defaultValue = "Guest") String name){

        model.addAttribute("name", name);

        return "welcome";
    }

}
