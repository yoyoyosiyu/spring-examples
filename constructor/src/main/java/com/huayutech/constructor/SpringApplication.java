package com.huayutech.constructor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class SpringApplication {

    public static void main(String [] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringApplication.class);

        ClassA a = context.getBean(ClassA.class);

    }


}
