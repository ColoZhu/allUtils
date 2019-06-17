package com.utils.bigDecimal;

import java.math.BigDecimal;

public class BigDecimalTest {

    public static void main(String[] args) {


        BigDecimal b1 = new BigDecimal(150);

        BigDecimal b2 = new BigDecimal(150);





        // 浮点数的打印
        System.out.println("浮点数的打印 :" );
        System.out.println(new BigDecimal("10000000000").toString());

        // 普通的数字字符串
        System.out.println("普通的数字字符串 :" );
        System.out.println(new BigDecimal("100.000").toString());

        // 去除末尾多余的0
        System.out.println("去除末尾多余的0 :" );
        System.out.println(new BigDecimal("100.000").stripTrailingZeros().toString());

        // 避免输出科学计数法
        System.out.println("避免输出科学计数法 :" );
        System.out.println(new BigDecimal("100.000").stripTrailingZeros().toPlainString());
        }
}
