package com.huayutech.constructor;

import org.springframework.stereotype.Component;

@Component
public class ClassA {

    public ClassA(ClassB b, ClassC c) {

        System.out.println(b.getClass().toString());
        System.out.println(c.getClass().toString());

    }

}
