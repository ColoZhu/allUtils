package com.utils.annotation;


import java.lang.reflect.InvocationTargetException;


/**
 * Test.java
 *
 *  运行的代码
 */
public class Test {
    public static void main(String[] args) throws IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {
        User user = UserFactory.create();

        System.out.println(user.getName());
        System.out.println(user.getAge());
    }
}