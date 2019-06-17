package com.utils.algorithm;

import java.util.ArrayList;

import java.util.Random;

public class MaximumSubsequenceSum {

    //最大子序列和问题
    public static void main(String[] args) {
        int length = 10;
        int[] a = new int[length];
        //随机产生[-10,10] 之间整数
        for (int i = 0; i < length; i++) {
            int randomNum = new Random().nextInt(20) - 9;  //-10--->10之间
            a[i] = randomNum;
            System.out.print(randomNum + " ");
        }
        System.out.println();
        int maxSum = maxSubSum4(a);
        System.out.println("maxSum :" + maxSum);
    }

    //最大子序列求和(有正数也有负数)
    public static int maxSubSum4(int[] a) {
        int maxSum = 0, thisSum = 0;  //初始化最大和为0, 以及内部循环的序列和为0
        for (int j = 0; j < a.length; j++) {
            thisSum += a[j];

            if (thisSum > maxSum) {
                maxSum = thisSum;       //如果当前的数a[i]>0,那么maxSum肯定会改变
            } else if (thisSum < 0) {
                thisSum = 0;            //如果序列和thisSum因为加上a[i]会变成负数,那么从i+1开始重新thisSum  看是否有数据>之前的maxSum
            }

        }
        return maxSum;
    }


}
