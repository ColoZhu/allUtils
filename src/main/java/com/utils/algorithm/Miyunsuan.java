package com.utils.algorithm;

import java.math.BigInteger;

public class Miyunsuan {


    public static void main(String[] args){
       // System.out.println(pow(BigInteger.valueOf(99999),888));
        System.out.println(pow(BigInteger.valueOf(20),20));
    }
    public static BigInteger pow(BigInteger x,int n){
        if(n == 0)
            return BigInteger.ONE;
        if(n == 1)
            return x;
        if(isEven(n))
            return pow(x.multiply(x),n/2);
        else
            return pow(x.multiply(x),n/2).multiply(x);
    }
    private static boolean isEven(int n) {
        // 判断是否为偶数
        if(n % 2 == 0)
            return true;
        else
            return false;
    }


    static long pow(long x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n % 2 == 0) {
            return pow(x * x, n / 2);
        } else {
            return pow(x * x, n / 2) * x;
        }
    }

}
