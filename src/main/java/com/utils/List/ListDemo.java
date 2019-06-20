package com.utils.List;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class ListDemo {

    @Test
    public void test1() {

        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            arrayList.add(i);
        }

        long time1 = System.currentTimeMillis();

        System.out.println("time1 :" + time1);

        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) % 2 == 0) {
                arrayList.remove(arrayList.get(i));
            }
        }
        long time2 = System.currentTimeMillis();
        System.out.println("time2-time1 :" + (time2 - time1));  //10000->24  100000->1906

    }


    @Test
    public void test2() {

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 10000000; i++) {
            list.add(i);
        }

        long time1 = System.currentTimeMillis();
        System.out.println("time1 :" + time1);

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();  //98
        }


      /*  for (Integer vo : list) {
            Integer item = vo;   //92
        }*/
        /*for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
               // list.remove(list.get(i));
            }
        }*/
        long time2 = System.currentTimeMillis();
        System.out.println("time2-time1 :" + (time2 - time1));
        //linkedList的集合remove方法花费时间:10000->88毫秒  100000->9541毫秒
        //iterator的remove方法,10000->2毫秒   100000->10毫秒
    }

    @Test
    public void test3() {

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            list.add(i);
        }

        long time1 = System.currentTimeMillis();

        System.out.println("time1 :" + time1);

        for (Integer vo : list) {
            Integer item = vo;   //92
        }
        long time2 = System.currentTimeMillis();
        System.out.println("time2-time1 :" + (time2 - time1));  //10000->24  100000->1906


        list.clear();
    }


}
