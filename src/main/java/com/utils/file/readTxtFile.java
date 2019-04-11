package com.utils.file;

import org.apache.commons.lang.StringUtils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;


public class readTxtFile {
    /**
     * 功能：Java读取txt文件的内容
     * 步骤：1：先获得文件句柄
     * 2：获得文件句柄当做是输入一个字节码流，需要对这个输入流进行读取
     * 3：读取到输入流后，需要读取生成字节流
     * 4：一行一行的输出。readline()。
     * 备注：需要考虑的是异常情况
     *
     * @param filePath
     */
    public static String readTxtFile(String filePath) {

        StringBuffer str = new StringBuffer("");
        try {
            String encoding = "GBK";
            File file = new File(filePath);
            if (file.isFile() && file.exists()) { //判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file), encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    System.out.println(lineTxt);
                    str.append("\r\n" + lineTxt);
                }
                read.close();
            } else {
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }

        return str.toString();

    }

    public static void main(String argv[]) {
        //String filePath = "L:\\Apache\\htdocs\\res\\20121012.txt";
        String filePath = "I:\\testFile\\PT161031CN";
//      "res/";
        String resStr = readTxtFile(filePath);
        String[] split = resStr.split("'");
        for (String item : split) {
            if(item.contains("UNB+UNOA:")){
                System.out.println("报文头(去解析) :" + item);
            }
            if(item.contains("NAD+SU+")){
                System.out.println("供应商信息(去解析) :" + item);

            }
            if(item.contains("COM+")){
                System.out.println("电话(去解析) :" + item);
            }
            if(StringUtils.startsWith(item,"COM+") &&StringUtils.endsWith(item,"TE'") ){
                System.out.println("电话(去解析) :" + item);
            }
            if(StringUtils.startsWith(item,"COM+") &&StringUtils.endsWith(item,"FX'") ){
                System.out.println("传真(去解析) :" + item);
            }

        }
    }
}