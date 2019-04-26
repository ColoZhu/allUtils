package com.utils.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TestSafe {


    @Test
    public void test1() {
        System.out.println("hello :" + null);
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("aa", 1111);
        // map.put(null, 222);
        //  map.put(null, null);
        //  System.out.println("map :" + map);

        // Hashtable<String, Object> hashtable = new Hashtable<String, Object>();

        // hashtable.put("111", null);
        //hashtable.put(null, null);






    }


}
