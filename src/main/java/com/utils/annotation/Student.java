package com.utils.annotation;



import javax.validation.constraints.NotNull;

/**
 * User.java
 * 在数据模型使用注解
 */
public class Student {

    @NotNull(message = "name不能为空")
    private String name;
    @NotNull(message = "name不能为空")
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

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}