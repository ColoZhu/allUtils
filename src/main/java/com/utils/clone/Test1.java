package com.utils.clone;

class Student1 implements Cloneable {
    private int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public Object clone() {
        Student1 stu = null;
        try {
            stu = (Student1) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return stu;
    }
}

public class Test1 {
    public static void main(String args[]) {
        Student1 stu1 = new Student1();

        stu1.setNumber(12345);
        Student1 stu2 = (Student1) stu1.clone();

        System.out.println("学生1:" + stu1.getNumber());
        System.out.println("学生2:" + stu2.getNumber());

        stu2.setNumber(54321);

        System.out.println("学生1:" + stu1.getNumber());
        System.out.println("学生2:" + stu2.getNumber());
    }
}
