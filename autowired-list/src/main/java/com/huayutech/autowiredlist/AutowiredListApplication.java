package com.huayutech.autowiredlist;

import com.huayutech.autowiredlist.domain.Foobar1;
import com.huayutech.autowiredlist.domain.FoobarInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Configuration
@ComponentScan("com.huayutech.autowiredlist.domain")
public class AutowiredListApplication {

    @Component
    public static class Greeting {
        public String greeting = "Hello, Spring";


    }

    @Autowired
    private List<FoobarInterface> fooBars = Collections.emptyList();

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AutowiredListApplication.class);

        Greeting greeting = context.getBean(Greeting.class);

        AutowiredListApplication app =  context.getBean(AutowiredListApplication.class);

        //Foobar1 foobar1 = context.getBean(Foobar1.class);

        for (FoobarInterface foobar: app.fooBars) {
            System.out.println(foobar.getClass().toString());
        }

        System.out.println(greeting.greeting);
    }

}
