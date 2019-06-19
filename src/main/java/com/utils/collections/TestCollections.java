package com.utils.collections;

import org.junit.Test;
import org.milyn.util.CollectionsUtil;
import org.springframework.util.CollectionUtils;

import java.util.*;

public class TestCollections {

    public static void main(String[] args) {

        ArrayList<String> stringlist = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            stringlist.add(String.valueOf(i));
        }

        System.out.println("stringlist :" + stringlist);

     /*   Iterator<String> iterator_str = stringlist.iterator();
        while (iterator_str.hasNext()) {
            String item = iterator_str.next();  //ConcurrentModificationException
            if (item.equals("5")) {
                stringlist.remove(item);
            }
        }*/

        System.out.println("------------------------------ :" + 1);

        Map<String, String> map = new HashMap<>();

        map.put("111", "111");
        map.put("222", "222");
        map.put("333", "333");
        map.put("444", "444");
        map.put("555", "555");
        Set<String> keyList = map.keySet();

        //foreach方式
   /*     for (String key : keyList) {
            if (key.equals("444")) {
                map.remove(key);   //ConcurrentModificationException
            }
        }
*/

        //迭代器方式
 /*       Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();  //ConcurrentModificationException
            if (item.equals("444")) {
                map.remove(item);
            }
        }

*/
        ArrayList<String> list_string = new ArrayList<>();
        list_string.add("111");
        list_string.add("222");
        list_string.add("333");
        list_string.add("444");
        list_string.add("555");

        System.out.println("list_string :" + list_string);
      /*  Iterator<String> iterator_list_string = list_string.iterator();
        while (iterator_list_string.hasNext()) {
            String item = iterator_list_string.next();  //ConcurrentModificationException
            if (item.equals("333")) {
                list_string.remove(item);
            }
        }

*/
        //迭代器方式
        Iterator<String> iteratorList = list_string.iterator();
        while (iteratorList.hasNext()) {
            String item = iteratorList.next();  //ConcurrentModificationException
            if (item.equals("333")) {
                list_string.remove(item);
            }
        }
        System.out.println("list_string :" + list_string);
        //foreach方式
      /*  for (String vo : list_string) {
            if (vo.equals("444")) {
                list_string.remove(vo);  //这里不报错
            }
        }*/


        //普通for方式
     /*   for (int i = 0; i < list_string.size(); i++) {
            if (list_string.get(i).equals("444")) {
                list_string.remove(list_string.get(i));  //这里不报错  ,listIterator和普通的iterator区别,listIterato更高级
                list_string.add("222222222222");  //加到了末尾
            }

        }*/


    }

    /**
     * entrySet的iterator迭代器方式
     */
    //只获取key
    public static void entrySetIteratorGetKey(Map<String, String> map) {
        long startTime = System.currentTimeMillis();
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next().getKey();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("entrySetIteratorGetKey运行时间" + (endTime - startTime));
    }


    @Test
    public void test2() {

        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 20; i++) {
            map.put(i, i + "" + i);
        }
        //entrySet的iterator迭代器方式
        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Integer key = iterator.next().getKey(); //ConcurrentModificationException
            if (key == 5) {   //这里选择集合靠中间的数据操作
                map.remove(key);
            }
        }


        System.out.println("map :" + map);

    }


    @Test
    public void test3() {
        List<Integer> intList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            intList.add(Integer.valueOf(i));
        }

        // 迭代器遍历, 异常
        Iterator<Integer> iterator_int = intList.iterator();
        while (iterator_int.hasNext()) {
            Integer integer = iterator_int.next();  //ConcurrentModificationException
            if (integer.intValue() == 5) {   //这里选择集合靠中间的数据操作
               // intList.remove(integer);  //集合类remove
                iterator_int.remove(); //迭代器的remove()方法
                // intList.add(55);
            }
        }

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
