package com.kgl1688.mvc;

import com.kgl1688.entity.Book;
import com.kgl1688.entity.User;
import com.kgl1688.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Resource
    private UserService userService;

    @RequestMapping("/t")
    @ResponseBody
    public String home() {
        return "hello, world!";
    }


    @RequestMapping("/list")
    public @ResponseBody List<?> getList() {

        List<Book> list = new ArrayList();

        Book book = new Book();
        book.setId(10);
        book.setName("C++");

        list.add(book);

        return list;

    }

    @RequestMapping("/user")
    @ResponseBody
    public User getUser() {

        User user = new User();
        user.setAge(10);
        user.setFirst_name("simon");
        user.setLast_name("siyu");

        return user;
    }

}
