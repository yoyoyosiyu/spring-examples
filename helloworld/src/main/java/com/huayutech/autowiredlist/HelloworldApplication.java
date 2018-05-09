package com.huayutech.autowiredlist;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan
public class HelloworldApplication {

    @Component
    public static class Greeting {
        public String greeting = "Hello, Spring";


    }

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HelloworldApplication.class);

        Greeting greeting = context.getBean(Greeting.class);

        System.out.print(greeting.greeting);
    }

}
