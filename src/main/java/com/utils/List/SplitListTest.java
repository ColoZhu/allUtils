package com.utils.List;

import java.util.ArrayList;
import java.util.List;

public class SplitListTest {
    public static Integer WH_STORE_SKU_SIZE = 20;  //报文发送的最大条数


    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        List<List<Integer>> lists = splitList(list, WH_STORE_SKU_SIZE); // 每隔2000条循环一次 ;
        System.out.println("lists :" + lists);
    }

    /**
     * @Param:
     * @Description: 按指定数量对list分组
     * @Author: zyf    2019/5/9
     */
    public static List<List<Integer>> splitList(List<Integer> sourList, int maxSize) {
        List<List<Integer>> splitList = new ArrayList<>();
        if (sourList.size() > maxSize) {
            List<Integer> tempList = new ArrayList<>(); //临时的list,用于赋值和清空
            for (int i = 0; i < sourList.size(); i++) {
                Object o = sourList.get(i);
                tempList.add(sourList.get(i));//添加到临时list
                if ((i + 1) % maxSize == 0) {
                    //临时list添加到外层用于返回的list
                    splitList.add(tempList);
                    tempList = new ArrayList<>(); //每隔数量区间清空一下临时的list
                }

            }

        } else {
            splitList.add(sourList);  //不超过最大值时候直接返回,不用遍历
        }
        return splitList;
    }
}
