package com.utils.stack;

import org.junit.Test;

import java.util.Stack;

public class TestStack {


    @Test
    public void test1() {
        String codeStr = "{ [aa{a(123123)}]}";  //简单假设这是一段代码
        String codeStr2 = "{ [aa{a(12312)3)}]}";
        boolean result1 = checkCode(codeStr);
        boolean result2 = checkCode(codeStr2);

        System.out.println("result1 :" + result1);  //true
        System.out.println("result2 :" + result2);  //false
    }

    //校验代码的符号是否成对
    public boolean checkCode(String codeStr) {
        Stack<String> stacks = new Stack<>();
        for (int i = 0; i < codeStr.length(); i++) {
            String character = codeStr.substring(i, i + 1);
            if (character.equals("{") || character.equals("[") || character.equals("(")) {
                stacks.push(character);  //开放符号,即左边开放符号,压栈
            } else if (character.equals(")") || character.equals("]") || character.equals("}")) {
                //如果栈为空,返回false,不能以右闭符号开头
                if (stacks.isEmpty()) {
                    return false;
                }
                //弹出栈顶元素,最后的左开括号
                String pop = stacks.pop();
                //校验是否匹配
                if (character.equals(")")) {
                    if (!pop.equals("("))
                        return false;
                } else if (character.equals("]")) {
                    if (!pop.equals("["))
                        return false;
                } else if (character.equals("}")) {
                    if (!pop.equals("{"))
                        return false;
                }
            }

        }
        //此时栈中不应该再有左括号
        return stacks.isEmpty();
    }


}
