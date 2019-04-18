package com.utils.edi;




public class Test_Partin_DD {
    public static void main(String[] args) throws Exception {
       // String filePath = "I:\\testFile\\PT161031CN_2.txt";
         String filePath = "I:\\testFile\\PT161031CN_old";
        String strContent = FileUtil.readTxtFileToString(filePath, "GBK", true);
        FileUtil.writeStringToTxtFile(strContent, filePath+".utf8", "UTF-8");
        PartinDTO dto = PartinManager.read(filePath+".utf8");
         System.out.println("hello :" + dto);

    }
}
