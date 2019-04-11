package com.utils.print;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRAbstractExporter;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JExcelApiExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;

public class Test {

    public static void main(String[] args) throws Exception {
        String jasperName = "report2.jasper";//jasper文件名称
        String jasperPath = "D:/";//jasper文件所在目录
        File jasperFile = new File(jasperPath, jasperName);
        File excelFile = new File(jasperPath, jasperFile.getName() + ".xls");//要导出的Excel文件
        //如果存在，先删除以避免影响
        if (!excelFile.exists()) {
            System.gc();
            excelFile.delete();
        }
        //参数Parameter，对应于模板文件中的Parameter栏
        Map params = new HashMap();
        params.put("SUBREPORT_DIR", jasperPath);//若有子报表，可在此设置其目录
        JasperPrint jasperPrint = JasperFillManager.fillReport(new FileInputStream(jasperFile), params, getDataSource());
        //导出Excel
        JRAbstractExporter exporter = new JExcelApiExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, new FileOutputStream(excelFile));//绑定要导出的文件
        exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
        exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
        exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.TRUE);//TRUE背景设置为白色
        exporter.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
        //设置Excel的sheet名称
        String sheetName = "sheet1";
        String[] sheetNames = {sheetName};
        exporter.setParameter(JRXlsExporterParameter.SHEET_NAMES, sheetNames);
        exporter.exportReport();
        //快速打开Excel文件
        openFile(excelFile);
    }

    /**
     * 打开指定文件
     *
     * @param excelFile
     * @throws Exception
     */
    private static void openFile(File excelFile) throws Exception {
        final Runtime runtime = Runtime.getRuntime();
        Process process = null;//
        final String cmd = "rundll32 url.dll FileProtocolHandler file://" + excelFile.getAbsolutePath();
        process = runtime.exec(cmd);
    }

    /**
     * 生成数据源，在此模拟数据源数据
     *
     * @return
     * @throws Exception
     */
    private static JRDataSource getDataSource() throws Exception {
        ArrayList<Student> dataList = new ArrayList<Student>();
        for (int i = 1; i <= 10; i++) {
            Student stu = new Student();
            stu.setName("学生" + i);
            stu.setSex("男");
            dataList.add(stu);
        }
        JRDataSource dataSource = new JRBeanCollectionDataSource(dataList);
        return dataSource;
    }
}

