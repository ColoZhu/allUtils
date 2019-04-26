package com.utils.map;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TestForEachMap {

    /**
     * keySet的for循环方式
     */
    //只获取key
    public static void keySetForGetKey(Map<String, String> map) {
        long startTime = System.currentTimeMillis();
        for (String key : map.keySet()) {
        }
        long endTime = System.currentTimeMillis();
        System.out.println("keySetForGetKey运行时间" + (endTime - startTime));
    }

    //获取key和value
    public static void keySetForGetKeyAndValue(Map<String, String> map) {
        long startTime = System.currentTimeMillis();
        for (String key : map.keySet()) {
            String value = map.get(key);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("keySetForGetKeyAndValue运行时间" + (endTime - startTime));
    }

    /**
     * keySet的iterator迭代器方式
     */
    //只获取key
    public static void keySetIteratorGetKey(Map<String, String> map) {
        long startTime = System.currentTimeMillis();
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("keySetIteratorGetKey运行时间" + (endTime - startTime));
    }

    //获取key和value
    public static void keySetIteratorGetKeyAndValue(Map<String, String> map) {
        long startTime = System.currentTimeMillis();
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            String value = map.get(iterator.next());
        }
        long endTime = System.currentTimeMillis();
        System.out.println("keySetIteratorGetKeyAndValue运行时间" + (endTime - startTime));
    }

    /**
     * entrySet的for循环方式(个人比较喜欢)
     */
    //只获取key
    public static void entrySetForGetKey(Map<String, String> map) {
        long startTime = System.currentTimeMillis();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("entrySetForGetKey运行时间" + (endTime - startTime));
    }

    //获取key和value
    public static void entrySetForGetKeyAndValue(Map<String, String> map) {
        long startTime = System.currentTimeMillis();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("entrySetForGetKeyAndValue运行时间" + (endTime - startTime));
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

    //获取key和value
    public static void entrySetIteratorGetKeyAndValue(Map<String, String> map) {
        long startTime = System.currentTimeMillis();
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next().getKey();
            String value = iterator.next().getValue();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("entrySetIteratorGetKeyAndValue运行时间" + (endTime - startTime));
    }


    @Test
    public void test1() {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < 600000; i++) {
            map.put("1443990001" + i, "6944804590104");
        }

        keySetForGetKey(map);
        keySetForGetKeyAndValue(map);
        keySetIteratorGetKey(map);
        keySetIteratorGetKeyAndValue(map);
        entrySetForGetKey(map);
        entrySetForGetKeyAndValue(map);
        entrySetIteratorGetKey(map);
        entrySetIteratorGetKeyAndValue(map);
        /*
        keySetForGetKey运行时间19
        keySetForGetKeyAndValue运行时间29
        keySetIteratorGetKey运行时间16
        keySetIteratorGetKeyAndValue运行时间27
        entrySetForGetKey运行时间19
        entrySetForGetKeyAndValue运行时间19
        entrySetIteratorGetKey运行时间17
        entrySetIteratorGetKeyAndValue运行时间21
         */
    }

    @Test
    public void test2() {
        Map<String, String> skuMap = new HashMap<>();
        for (int i = 0; i < 60000; i++) {
            skuMap.put("1443990001" + i, "6944804590104");
        }

        long currentTime1 = System.currentTimeMillis();  //start

        for (Map.Entry<String, String> entry : skuMap.entrySet()) {
            String skuCode = entry.getKey();
            String barCode = entry.getValue();
            System.out.println(skuCode + " :" + barCode);
        }
        long currentTime2 = System.currentTimeMillis(); //end
        System.out.println("遍历map时间 :" + (currentTime2 - currentTime1));
    }


    @Test
    public void test3() {
        Map<String, String> skuMap = new HashMap<>();
        for (int i = 0; i < 60000; i++) {
            skuMap.put("1443990001" + i, "6944804590104");
        }

        long currentTime1 = System.currentTimeMillis();  //start

        for (Map.Entry<String, String> entry : skuMap.entrySet()) {
            String skuCode = entry.getKey();
            String barCode = entry.getValue();
            System.out.println(skuCode + " :" + barCode);
        }
        long currentTime2 = System.currentTimeMillis(); //end
        System.out.println("遍历map时间 :" + (currentTime2 - currentTime1));
    }


    @Test
    public void test4() {
        Map<String, String> skuMap = new HashMap<>();
        for (int i = 0; i < 60000; i++) {
            skuMap.put("1443990001" + i, "6944804590104");
        }

     /*   long currentTime1 = System.currentTimeMillis();  //start
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, String> entry : skuMap.entrySet()) {
            String skuCode = entry.getKey();
            String barCode = entry.getValue();
            sb.append(skuCode + " :" + barCode);
        }
        long currentTime2 = System.currentTimeMillis(); //end
        System.out.println("遍历map时间1 :" + (currentTime2 - currentTime1));

*/
        ArrayList<String> list = new ArrayList<>();

        long currentTime3 = System.currentTimeMillis(); //
        for (Map.Entry<String, String> entry : skuMap.entrySet()) {
            String skuCode = entry.getKey();
            String barCode = entry.getValue();
            list.add(skuCode + " :" + barCode);
        }
        long currentTime4 = System.currentTimeMillis(); //end
        System.out.println("遍历map时间2 :" + (currentTime4 - currentTime3));

    }


    @Test
    public void test5() {
        StringBuilder sb = new StringBuilder();
        sb.append("11111111--");
        // String lineSeparator = System.getProperty("line.separator");
        String lineSeparator = System.lineSeparator();
        sb.append(lineSeparator);
        sb.append("2222--");
        System.out.println("sb :" + sb.toString());
        //String lineSeparator = System.lineSeparator();
        // System.out.println(lineSeparator);

    }
}