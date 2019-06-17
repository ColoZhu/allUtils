package com.utils.test;

public class TestObject {


    public static void main(String[] args) {

          String a = "hello2";
    final String b = "hello";
          String d = "hello";
          String c = b + 2;
          String e = d + 2;
          String f ="hello"+"2";
        System.out.println(a == b); //false
        System.out.println(a == c); //true
        System.out.println(a == e); //false
        System.out.println(a == f); //true
        System.out.println(System.identityHashCode(a));
        System.out.println(System.identityHashCode(b));
        System.out.println(System.identityHashCode(c));
        System.out.println(System.identityHashCode(d));
        System.out.println(System.identityHashCode(e));
        System.out.println(System.identityHashCode(f));

    }
}
