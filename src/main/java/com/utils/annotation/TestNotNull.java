package com.utils.annotation;

import javax.validation.Valid;

public class TestNotNull {

    public static void main(String[] args) {
        TestNotNull t1 = new TestNotNull();
        Student s1 = new Student();
        s1.setName("111");
        t1.test(s1);
        Student s2 = new Student();
        t1.test(s2);
        //s2.setAge("12");

    }


    public void test(@Valid Student model) {
        System.out.println("校验非空 :" + model);
    }
}
