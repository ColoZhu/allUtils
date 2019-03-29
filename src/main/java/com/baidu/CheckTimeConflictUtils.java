package com.baidu;

import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class CheckTimeConflictUtils {
    public static final String DATE_FORMAT_Y_M_DHMS = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FORMAT_Y_M_DHM = "yyyy-MM-dd HH:mm";
    public static final String DATE_FORMAT_YY_MM_DD = "yyyy-MM-dd";

    /**
     * @Param:
     * @Description: list自身查询有无时间冲突,
     * 优化: 如果自身的list过大, j遍历不能从0开始,只需要往后面数据比较大小
     * @Author: zyf    2019/3/29
     */
    public static String checkSelf(List<TimeModel> list) {
        String res = null;
        if (list.size() == 0) {
            return res;
        }
        for (int i = 0; i < list.size(); i++) {
            // long I_S = list.get(i).getEffectiveStartTime().getTime();
            // long I_E = list.get(i).getEffectiveEndTime().getTime();
            Date I_S = list.get(i).getStartTime();
            Date I_E = list.get(i).getEndTime();
            for (int j = 0; j < list.size(); j++) {
                if (i == j) {
                    continue;  //自身不跟自身比较
                }
                Date J_S = list.get(j).getStartTime();
                Date J_E = list.get(j).getEndTime();
                //这里使用compareTo方法, 因为getTime()的时间不太准确
                if ((J_S.compareTo(I_S) == -1 && I_S.compareTo(J_E) == -1)
                        || (J_S.compareTo(I_E) == -1 && I_E.compareTo(J_E) == -1)
                        || J_E.compareTo(I_S) == 0 || J_S.compareTo(I_E) == 0
                        || J_E.compareTo(I_E) == 0 || J_S.compareTo(I_S) == 0) {
                    res =  dateToStr(list.get(i).getStartTime()) + " "
                            + dateToStr(list.get(i).getEndTime());
                    break;
                }
            }
        }
        return res;
    }


    /**
     * @Param: listNew 前端传的list
     * @Param: listOld 数据库list
     * @Description: 比较前端传的list跟数据库list有无时间冲突
     * @Author: zyf    2019/3/29
     */
    public static String checkTwoList(List<TimeModel> listNew, List<TimeModel> listOld) {
        String res = null;
        for (int i = 0; i < listNew.size(); i++) {
            Date I_S = listNew.get(i).getStartTime();
            Date I_E = listNew.get(i).getEndTime();
            Long jobIdNew = listNew.get(i).getJobId();
            for (int j = 0; j < listOld.size(); j++) {
                Long jobIdOld = listOld.get(j).getJobId();
                Date J_S = listOld.get(j).getStartTime();
                Date J_E = listOld.get(j).getEndTime();

                if (jobIdNew != null && jobIdNew.longValue() == jobIdOld.longValue()) {
                    continue; // 前台如果是旧数据修改不能再跟自己比较
                }

                if ((J_S.compareTo(I_S) == -1 && I_S.compareTo(J_E) == -1)
                        || (J_S.compareTo(I_E) == -1 && I_E.compareTo(J_E) == -1)
                        || J_E.compareTo(I_S) == 0 || J_S.compareTo(I_E) == 0
                        || J_E.compareTo(I_E) == 0 || J_S.compareTo(I_S) == 0) {
                    res = dateToStr(listNew.get(i).getStartTime()) + " "
                            + dateToStr(listNew.get(i).getEndTime());
                    break;
                }
            }
        }
        return res;
    }


    // date转String
    public static String dateToStr(Date date) {
        String strDate = "";
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_Y_M_DHM);
        strDate = sdf.format(date);
        return strDate;
    }

    // string转date
    public static Date strToDate(String dateString) {
        Date formateDate = null;
        DateFormat format = new SimpleDateFormat(DATE_FORMAT_Y_M_DHM);
        try {
            formateDate = format.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formateDate;
    }

    /**
     * @Param:
     * @Description: 实体类
     * @Author: zyf    2019/3/29
     */

    class TimeModel {
        private Long jobId; //主键
        private Date startTime;//开始时间
        private Date endTime;   //结束时间
        public Long getJobId() {
            return jobId;
        }
        public void setJobId(Long jobId) {
            this.jobId = jobId;
        }
        public Date getStartTime() {
            return startTime;
        }
        public void setStartTime(Date startTime) {
            this.startTime = startTime;
        }
        public Date getEndTime() {
            return endTime;
        }
        public void setEndTime(Date endTime) {
            this.endTime = endTime;
        }
    }


    //测试
    @Test
    public void test01() {

        /*
        * 这里模拟一下数据库存储的时间格式,精确到秒,实际情况直接进行比较的是Date类型
        * 注意:时间点不能相等
        * */
        //model1 的开始-结束时间  2019-03-01 14:51:00  2019-03-05 14:52:00
        //model2 的开始-结束时间  2019-03-05 14:53:00  2019-03-05 14:54:00
        //model3 的开始-结束时间  2019-03-02 14:53:00  2019-03-05 14:53:00

        List<TimeModel> list = new ArrayList<>();
        List<TimeModel> listOld = new ArrayList<>();
        TimeModel mode1 = new TimeModel();
        mode1.setStartTime(strToDate("2019-03-01 14:51:00"));
        mode1.setEndTime(strToDate("2019-03-05 14:52:00"));

        TimeModel mode2 = new TimeModel();
        //mode2.setStartTime(strToDate("2019-03-05 14:51:00"));  //checkSelf()使用
        mode2.setStartTime(strToDate("2019-03-05 14:53:00")); //checkTwoList()使用
        mode2.setEndTime(strToDate("2019-03-05 14:54:00"));

        TimeModel mode3 = new TimeModel();
        mode3.setStartTime(strToDate("2019-03-02 14:53:00"));
        mode3.setEndTime(strToDate("2019-03-05 14:58:00"));

        list.add(mode1);
        list.add(mode2);

        //String res = checkSelf(list);  //checkSelf()使用

        listOld.add(mode3);  //checkTwoList()使用
        String res = checkTwoList(list,listOld);
        System.out.println("冲突的时间段:"  + res);

    }

}
