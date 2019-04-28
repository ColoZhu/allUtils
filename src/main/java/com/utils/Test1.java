package com.utils;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test1 {

    private Long type = 1 == 2 ? 7L : 8L;

     

    @Test
    public void test() {
        Test1 test1 = new Test1();
        System.out.println("test1 :" + test1.type);


    }


}