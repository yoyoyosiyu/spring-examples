package com.huayutech.annotation;

import com.huayutech.annotation.annotation.ConditionalOnMissingBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableFeatureA
@ComponentScan
public class AnnotationApplication {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AnnotationApplication.class);

        AnnotationApplication app = context.getBean(AnnotationApplication.class);

        String[] names = context.getBeanNamesForType(ComponentA.class);

        System.out.println(context.getBean(ComponentA.class).getClass().toString());
        System.out.println(context.getBean(FeatureA.class).getClass().toString());

    }
}
