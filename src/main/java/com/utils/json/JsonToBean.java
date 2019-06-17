package com.utils.json;

public class JsonToBean {

    //json转换为实体类

     public static void main(String[] args) {
             System.out.println("hello :" + null);

         }

}


class Student {

    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}