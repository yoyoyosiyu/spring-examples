package com.huayutech.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableFeatureA
public class AnnotationApplication {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AnnotationApplication.class);

        System.out.println(context.getBean(FeatureA.class).getClass().toString());

    }
}
