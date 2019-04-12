package com.utils.annotation;


import com.sun.istack.internal.NotNull;

/**
 * User.java
 * 在数据模型使用注解
 */
public class User {
    private String name;
    private String age;

    public String getName() {
        return name;
    }


    @Init(value = "liang")
    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    @Init(value = "23")
    public void setAge(String age) {
        this.age = age;
    }
}