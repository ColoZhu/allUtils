package com.utils.annotation;


/**
 * Test.java
 * 运行的代码
 */
public class TestUser2 {
    public static void main(String[] args) {
        User2 user2 = new User2();

        user2.setName("liang");
        user2.setAge("1");

        System.out.println(User2Check.check(user2));
    }
}