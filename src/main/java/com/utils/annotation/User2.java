package com.utils.annotation;


/**
 * User2.java
 * <p>
 * 在数据模型使用注解
 */
public class User2 {
    @Validate(min = 2, max = 5)
    private String name;

    @Validate(isNotNull = false)
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}