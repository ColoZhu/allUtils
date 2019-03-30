package com.baidu;



import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class HashMap_JDK8 {


    @Test
    public void test2() {


        List<CdWhStaffTimeModel> list = new ArrayList<>();
        List<CdWhStaffTimeModel> listOld = new ArrayList<>();
        CdWhStaffTimeModel cd1 = new CdWhStaffTimeModel();
        cd1.setEffectiveStartTime(strToDate("2019-03-01"));
        cd1.setEffectiveEndTime(strToDate("2019-03-03"));

        CdWhStaffTimeModel cd2 = new CdWhStaffTimeModel();
        cd2.setEffectiveStartTime(strToDate("2019-03-05"));
        cd2.setEffectiveEndTime(strToDate("2019-03-06"));

        list.add(cd1);
        list.add(cd2);


        CdWhStaffTimeModel cd3 = new CdWhStaffTimeModel();
        cd3.setEffectiveStartTime(strToDate("2019-03-02"));
        cd3.setEffectiveEndTime(strToDate("2019-03-05"));
        listOld.add(cd3);

        //String res = checkSelf(list);
        String res = checkTwoList(list, listOld);
        System.out.println("res :" + res);

    }


    public static String checkTwoList(List<CdWhStaffTimeModel> listNew, List<CdWhStaffTimeModel> listOld) {
        String res = null;
        for (int i = 0; i < listNew.size(); i++) {
            long I_S = listNew.get(i).getEffectiveStartTime().getTime();
            long I_E = listNew.get(i).getEffectiveEndTime().getTime();
            for (int j = 0; j < listOld.size(); j++) {

                long J_S = listOld.get(j).getEffectiveStartTime().getTime();
                long J_E = listOld.get(j).getEffectiveEndTime().getTime();
                if (J_S < I_S && I_S < J_E || J_S < I_E && I_E < J_E) {
                    res = dateToStr(listNew.get(i).getEffectiveStartTime()) + " " + dateToStr(listNew.get(i).getEffectiveEndTime());
                    break;
                }
            }
        }
        return res;
    }


    public static String checkSelf(List<CdWhStaffTimeModel> list) {
        String res = null;
        for (int i = 0; i < list.size(); i++) {
            long I_S = list.get(i).getEffectiveStartTime().getTime();
            long I_E = list.get(i).getEffectiveEndTime().getTime();
            for (int j = 0; j < list.size(); j++) {
                if (i == j) {
                    continue;
                }
                long J_S = list.get(j).getEffectiveStartTime().getTime();
                long J_E = list.get(j).getEffectiveEndTime().getTime();
                if (J_S < I_S && I_S < J_E || J_S < I_E && I_E < J_E) {
                    res = dateToStr(list.get(i).getEffectiveStartTime()) + " " + dateToStr(list.get(i).getEffectiveEndTime());
                    break;
                }
            }
        }
        return res;
    }


    public static String dateToStr(Date date) {
        String strDate = "";
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        strDate = sdf.format(date);
        return strDate;
    }

    public static Date strToDate(String dateString) {
        Date formateDate = null;
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            formateDate = format.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formateDate;
    }

    @Test
    public void test1() {
        System.out.println("hello :" + null);
        Map<String, Object> map = new HashMap<String, Object>();

        // map.put("aa", 1111);
        // map.put(null, 222);
        //  map.put(null, null);
        //  System.out.println("map :" + map);

        // Hashtable<String, Object> hashtable = new Hashtable<String, Object>();

        // hashtable.put("111", null);
        //hashtable.put(null, null);
        Object o = new Object();
        int i = o.hashCode();
        System.out.println("i :" + i);


        Double a = 2.00;
        Long b = 1L;
        double v = a / b;

        System.out.println(a / b);

        System.out.println((a / b) + 0.00d);

    }




    @Test
    public void testHash() {
        int a = 1;
        int hashValue = jdk8_hashmap_hash("a");
        System.out.println("hashValue :" + hashValue);
        int hashValue2 = jdk8_hashmap_hash(a);
        System.out.println("hashValue2 :" + hashValue2);

    }

    //jdk8的hashmap里面的hash算法
    static final int jdk8_hashmap_hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }


    class CdWhStaffTimeModel {

        private Date effectiveStartTime;// 有效开始时间
        private Date effectiveEndTime; // 有效结束时间

        public Date getEffectiveStartTime() {
            return effectiveStartTime;
        }

        public void setEffectiveStartTime(Date effectiveStartTime) {
            this.effectiveStartTime = effectiveStartTime;
        }

        public Date getEffectiveEndTime() {
            return effectiveEndTime;
        }

        public void setEffectiveEndTime(Date effectiveEndTime) {
            this.effectiveEndTime = effectiveEndTime;
        }


    }


}
