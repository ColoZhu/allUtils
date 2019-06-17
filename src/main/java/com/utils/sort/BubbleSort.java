package com.utils.sort;


public class BubbleSort {
    //冒泡排序
//核心思想：比较两个元素，如果前一个比后一个大则进行交换，经过对每个元素的比较，最后最大的元素被放在在最后位置
    public static void bubbleSort(int arr[]) {
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {//有N个元素只需比较N-1次
            boolean flag = false;             //设置是否有元素交换的标志，false表示没有，true表示有元素进行交换
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;  //元素移动了3次
                    flag = true;    //如果交换了则变为true
                }

            }
            if (!flag)//如：5 4 3 2 1 7 8 9
                break; //如果flag为false，则说说明这一趟没有起先交换 ，已经排序好了，就不用再比较了
        }
    }

    public static void main(String[] args) {
        int array[] = {5, 8, 4, 1, 2, 9};
        System.out.println("排序之前：");
        for (int element : array) {
            System.out.print(element + " ");
        }

        bubbleSort(array);
        System.out.println("\n排序之后：");
        for (int element : array) {
            System.out.print(element + " ");
        }
    }

}