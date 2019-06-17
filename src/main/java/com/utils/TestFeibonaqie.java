package com.utils;

import java.util.ArrayList;
import java.util.List;

public class TestFeibonaqie {

    public static void main(String[] args) {


        /*测试合并两个类型相同的list*/
        List<String> list1 = new ArrayList<String>();
        List<String> list2 = new ArrayList<String>();
        //给list1赋值
        list1.add("测");
        list1.add("试");
        list1.add("一");
        list1.add("下");
        //给list2赋值
        list2.add("合");
        list2.add("并");
        list2.add("列");
        list2.add("表");
        //将list1.list2合并
        list1.addAll(list2);
        //循环输出list1 看看结果
        for (String s : list1) {
            System.out.print(s);
        }

        System.out.println();

        int num = 10;

        List<Integer> integers = printF(num);


        System.out.println("integers :" + integers);
    }

    //斐波那契数列
    public static List<Integer> printF(int count) {
        int a = 0, b = 1, countIn = 0;
        List<Integer> list = new ArrayList<>();
        while (true) {
            if (countIn > count) {
                return list;
            }
            list.add(a);   //这里从0开始
            int sum = a + b;
            a = b;
            b = sum;
            countIn++;
            //list.add(a);   //这里从1开始
        }
    }
}
