package com.kgl1688.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class pathController {

    @RequestMapping("/books/{bookid}")
    @ResponseBody
    // 当路径变量的名字不同的时候，必须指出其名字
    public String getBook(@PathVariable("bookid") int bookID) {
        return "book id is " + bookID;
    }

    @RequestMapping("/books1/{bookid}")
    @ResponseBody
    // 当路径变量的名字相同的时候，@PathVariable括号里的名字可以省略
    public String getBook1(@PathVariable int bookid) {
        return "book id is " + bookid;
    }

}
