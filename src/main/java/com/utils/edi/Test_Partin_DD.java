package com.utils.edi;


import org.junit.Test;

public class Test_Partin_DD {
    public static void main(String[] args) throws Exception {
        // String filePath = "I:\\testFile\\PT161031CN_2.txt";
        String filePath = "I:\\testFile\\PC161031E3";  //INVOIC.edi
        String strContent = FileUtil.readTxtFileToString(filePath, "GBK", true);
        FileUtil.writeStringToTxtFile(strContent, filePath + ".utf8", "UTF-8");
        PartinDTO dto = PartinManager.read(filePath + ".utf8");
        System.out.println("hello :" + dto);

    }

    @Test
    public void test1() {
        // String filePath = "I:\\testFile\\PT161031CN_2.txt";
        String filePath = "I:\\testFile\\PC_xiao";  //INVOIC.edi
        String strContent = FileUtil.readTxtFileToString(filePath, "GBK", true);
        FileUtil.writeStringToTxtFile(strContent, filePath + ".utf8", "UTF-8");
        PricatManager.read(filePath + ".utf8");
    }
}
