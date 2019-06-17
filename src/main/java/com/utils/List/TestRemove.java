package com.utils.List;

import java.util.*;

public class TestRemove {


    public static void main(String[] args) {

        LinkedList<String> list = new LinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");



            for (String item : list) {
                if (item.equals("4")) {
                    list.remove(item);
                    list.add("44");
                }
            }



        System.out.println("list :" + list);


    }
}
