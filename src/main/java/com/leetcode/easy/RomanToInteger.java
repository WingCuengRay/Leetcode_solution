package com.leetcode.easy;

import java.util.Stack;

/**
 * Created by Yongcong Lei on 8/23/2019
 */
public class RomanToInteger {
    public enum Roman {
        M(1000), D(500), C(100), L(50), X(10), V(5), I(1);

        private final int value;

        Roman(int value){
            this.value = value;
        }

        public static Roman valueOf(char ch){
            for(Roman val : Roman.values()){
                if(val.name().charAt(0) == ch)
                    return val;
            }

            throw new IllegalArgumentException("illegal input");
        }
    }

    /**
     * using stack with enum
     *
     * Time: 7 ms  ( >=35.92% )
     * Memory: 36.1 MB
     */
    public int romanToIntWitStackAndEnum(String s) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            Roman romanVal = Roman.valueOf(s.charAt(i));

            if(!stack.isEmpty() && romanVal.value > stack.peek()){
                int tmp = stack.pop();
                stack.push(romanVal.value - tmp);
            } else {
                stack.push(romanVal.value);
            }
        }

        int result = 0;
        while(!stack.isEmpty()){
            result += stack.pop();
        }

        return result;
    }

    /**
     * using stack without enum
     *
     * Time: 6 ms  ( >=51.54% )
     * Memory: 33.4 MB
     */
    public static int romanToIntWithStack(String s) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            int val = getValue(s.charAt(i));

            if(!stack.isEmpty() && val > stack.peek()){
                int tmp = stack.pop();
                stack.push(val - tmp);
            } else {
                stack.push(val);
            }
        }

        int result = 0;
        while(!stack.isEmpty()){
            result += stack.pop();
        }

        return result;
    }


    public static int getValue(char ch){
        if(ch == 'M')
            return 1000;
        else if(ch == 'D')
            return 500;
        else if(ch == 'C')
            return 100;
        else if(ch == 'L')
            return 50;
        else if(ch == 'X')
            return 10;
        else if(ch == 'V')
            return 5;
        else if(ch == 'I')
            return 1;
        else
            throw new IllegalArgumentException("illegal input");
    }
}
