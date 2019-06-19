package com.utils.tree;

public abstract class AbstractClassB extends AbstractClass {

    void run() {
        System.out.println("AbstractClassB run:");

    }


}


class C extends AbstractClassB {


    public static void main(String[] args) {
        C c = new C();
        c.run();  //AbstractClassB run:
    }
}