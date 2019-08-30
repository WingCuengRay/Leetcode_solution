package com.leetcode.easy;

import java.util.Stack;

/**
 * Created by Yongcong Lei on 8/29/2019
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char ch: s.toCharArray()){
            if(ch == '(' || ch == '[' || ch == '{')
                stack.push(ch);
            else {
                if(stack.isEmpty())
                    return false;

                char left = stack.pop();
                if( (left == '(' && ch == ')') ||
                    (left == '[' && ch == ']') ||
                    (left == '{' && ch == '}') )
                    continue;
                else
                    return false;
            }
        }

        if(stack.isEmpty())
            return true;
        else
            return false;
    }
}
