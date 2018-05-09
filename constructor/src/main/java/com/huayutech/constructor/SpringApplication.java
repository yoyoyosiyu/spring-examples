package com.huayutech.constructor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class SpringApplication {

    public static void main(String [] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringApplication.class);

    }


}
