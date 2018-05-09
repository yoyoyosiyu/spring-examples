package com.huayutech.importannotation;


import org.springframework.context.annotation.Bean;

public class ClassA {

    @Bean
    public ClassB getClassB() {
        return new ClassB();
    }

    public class ClassB {

    }
}
