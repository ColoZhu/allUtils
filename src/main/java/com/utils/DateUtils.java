package com.utils;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {


    @Test
    public void test1() {

        String s = longToDate(1577721600000L);
         System.out.println("s :" + s);
         //s :2019-12-31 00:00:00
    }


    /**
     * @Description: long类型转换成日期
     * @param lo 毫秒数
     * @return String yyyy-MM-dd HH:mm:ss
     */
    public static String longToDate(long lo){
        Date date = new Date(lo);
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sd.format(date);
    }
}
