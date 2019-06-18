package com.utils.map;

import java.util.*;
import java.util.Map.Entry;

public class LinkedHashMapDemo {


    public static void main(String[] args) {
        //插入排序,默认
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("name1", "josan1");
        linkedHashMap.put("name2", "josan2");
        linkedHashMap.put("name3", "josan3");
        Set<Entry<String, String>> set = linkedHashMap.entrySet();
        Iterator<Entry<String, String>> iterator = set.iterator();
        //123顺序
        while (iterator.hasNext()) {
            Entry entry = iterator.next();
            String key = (String) entry.getKey();
            String value = (String) entry.getValue();
            System.out.println("key:" + key + ",value:" + value);
        }

        System.out.println("linkedHashMap_accessOrder :");


        /*基于访问排序*/
        LinkedHashMap<String, String> linkedHashMap_accessOrder = new LinkedHashMap<>(10,0.75f,true);
        linkedHashMap_accessOrder.put("name1", "josan1");
        linkedHashMap_accessOrder.put("name2", "josan2");
        linkedHashMap_accessOrder.put("name3", "josan3");
        linkedHashMap_accessOrder.put("name4", "josan4");
        linkedHashMap_accessOrder.put("name5", "josan5");

        linkedHashMap_accessOrder.get("name5");
        linkedHashMap_accessOrder.get("name1");
        linkedHashMap_accessOrder.get("name2");
        linkedHashMap_accessOrder.get("name4");
        linkedHashMap_accessOrder.get("name3");
        //51243顺序
        for (Map.Entry<String, String> entry : linkedHashMap_accessOrder.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println("key:" + key + ",value:" + value);
        }


    }
}
