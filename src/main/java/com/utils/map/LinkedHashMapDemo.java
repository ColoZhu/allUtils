package com.utils.map;

import java.util.*;
import java.util.Map.Entry;

public class LinkedHashMapDemo {


    public static void main(String[] args) {
       Map<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("name1", "josan1");
        linkedHashMap.put("name2", "josan2");
        linkedHashMap.put("name3", "josan3");
        Set<Entry<String, String>> set = linkedHashMap.entrySet();
        Iterator<Entry<String, String>> iterator = set.iterator();
        while (iterator.hasNext()) {
            Entry entry = iterator.next();
            String key = (String) entry.getKey();
            String value = (String) entry.getValue();
            System.out.println("key:" + key + ",value:" + value);
        }

        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("name1", "josan1");
        hashMap.put("name2", "josan2");
        hashMap.put("name3", "josan3");

        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println("key:" + key + ",value:" + value);
        }





    }
}
