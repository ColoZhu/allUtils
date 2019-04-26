package com.utils;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test1 {


    @Test
    public void test1() {

        // ArrayList<String> skuCodeList = new ArrayList<>();
        //skuCodeList.add("商品有入库记录无法更新包装规格!商品编码:" + "BNXX211" + " 新包装规格:" + "ANXX211");
        //skuCodeList.add("商品有入库记录无法更新包装规格!商品编码:" + "BNXX211" + " 新包装规格:" + "ANXX211");
        // skuCodeList.add("商品有入库记录无法更新包装规格!商品编码:" + "BNXX211" + " 新包装规格:" + "ANXX211");
        //System.out.println("skuCodeList :" + skuCodeList);
       /*  for(String item : skuCodeList) {
             System.out.println(  item);
         }*/


    /*    List<String> a = new ArrayList<>();
        a.add("1");
        a.add("2");
        //a.add("3");
        for (String temp : a) {
            if ("1".equals(temp)) {
                a.remove(temp);
            }
        }
*/

        Map<String, String> skuMap = new HashMap<>();


        for (int i = 0; i < 60000; i++) {
            skuMap.put ("1443990001"+i, "6944804590104");
        }
        long currentTime1 = System.currentTimeMillis();


        for (Map.Entry<String, String> entry : skuMap.entrySet()) {
            String skuCode = entry.getKey();
            String barCode = entry.getValue();
            System.out.println(skuCode+" :" + barCode);
        }
        long currentTime2 = System.currentTimeMillis();
        System.out.println("遍历map时间 :" + (currentTime2 - currentTime1));
    }
}