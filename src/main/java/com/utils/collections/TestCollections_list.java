package com.utils.collections;

import org.junit.Test;

import java.util.*;

public class TestCollections_list {


    @Test
    public void test1() {
        List<Integer> intList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            intList.add(Integer.valueOf(i));
        }

        // 迭代器遍历, 异常
       /* Iterator<Integer> iterator_int = intList.iterator();
        while (iterator_int.hasNext()) {
            Integer integer = iterator_int.next();  //ConcurrentModificationException
            if (integer.intValue() == 5) {   //这里选择集合靠中间的数据操作
                intList.remove(integer);
                // intList.add(55);
            }
        }*/

        // foreach遍历, 异常
      /*  for (Integer value : intList) {  //ConcurrentModificationException
            if (value.intValue() == 5) {
                intList.remove(value);
            }
        } */

        //普通for循环 , 正常
        for (int i = 0; i < intList.size(); i++) {
            if (intList.get(i) == 5) {
                intList.remove(intList.get(i));
            }
        }

    }


}
