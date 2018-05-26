package com.huayutech.beanscope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.SessionScope;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@SpringBootApplication
public class BeanScopeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeanScopeApplication.class, args);
    }


    @RestController
    @SessionScope
    public static  class MyController {

        @Autowired
        @Qualifier("foobar")
        protected Foobar foobar;



        @Autowired
        @Qualifier("sessionBar")
        protected Foobar sessionBar;


        @RequestMapping("setName")
        protected void doSetName(@Autowired @Qualifier("requestBar") Foobar requestBar) {

            foobar.setName("foobar");
            requestBar.setName("request bar");
            sessionBar.setName("session bar");

        }

        @RequestMapping("getName")
        protected List<?> setNames(@Autowired @Qualifier("requestBar") Foobar requestBar) {

            List<String> list = Arrays.asList(foobar.getName(), requestBar.getName(), sessionBar.getName());

            return list;


        }
    }

    @Configuration
    public static class Config {

        @Bean
        public Foobar foobar() {
            return new Foobar();
        }

        @Bean
        @Scope(value = "request", proxyMode = ScopedProxyMode.DEFAULT)
        public Foobar requestBar() {
            return new Foobar();
        }

        @Bean
        @Scope(value = "session", proxyMode = ScopedProxyMode.DEFAULT)
        public Foobar sessionBar() {
            return new Foobar();
        }



    }

    public static class Foobar {
        String name = null;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
