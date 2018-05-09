package com.huayutech.importannotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan
@Import({ClassA.class})
public class ImportAnnotationApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ImportAnnotationApplication.class);

        ClassA a = context.getBean(ClassA.class);
        ClassA.ClassB b = context.getBean(ClassA.ClassB.class);
        System.out.println(a.getClass().toString());
        System.out.println(b.getClass().toString());
    }

}
