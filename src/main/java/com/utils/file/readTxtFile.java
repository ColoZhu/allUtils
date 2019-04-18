package com.utils.file;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;


public class readTxtFile {
    /**
     * 功能：Java读取txt文件的内容,读成一行
     * 步骤：1：先获得文件句柄
     * 2：获得文件句柄当做是输入一个字节码流，需要对这个输入流进行读取
     * 3：读取到输入流后，需要读取生成字节流
     * 4：一行一行的输出。readline()。
     * 备注：需要考虑的是异常情况
     *
     * @param filePath
     * @author zyf
     */
    public static String readFileToOneLine(String filePath) {
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
                    // System.out.println(lineTxt);
                    //str.append("\r\n" + lineTxt);
                    str.append(lineTxt);  //不换行
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
        String resStr = readFileToOneLine(filePath);
        System.out.println(resStr);
    }
}