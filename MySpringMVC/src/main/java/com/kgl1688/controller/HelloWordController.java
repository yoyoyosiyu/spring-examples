package com.kgl1688.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/main")
public class HelloWordController {

    @RequestMapping(method= RequestMethod.GET)
    @ResponseBody
    public String Welcome() {
        return "hello, world";
    }
}
