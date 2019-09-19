package com.leetcode.medium;


/**
 * Created by Yongcong Lei on 9/18/2019
 */
public class StringToInteger {
    public int myAtoi(String str) {
        int i = 0;

        // trimming heading space
        while (i < str.length()) {
            if (str.charAt(i) == ' ') {
                i++;
            } else {
                break;
            }
        }
        str = str.substring(i);

        // check exception case
        boolean isPositive = true;
        if (str.isEmpty()) {
            return 0;
        }
        if (!(str.charAt(0) == '-' || str.charAt(0) == '+' || (str.charAt(0) >= '0'
            && str.charAt(0) <= '9'))) {
            return 0;
        }

        // trimming heading '-' or '+'
        if (str.charAt(0) == '-' || str.charAt(0) == '+') {
            isPositive = str.charAt(0) == '+';
            str = str.substring(1);
        }

        // transform the string into integer
        int number = 0;
        for (i = 0; i < str.length() && isDigit(str.charAt(i)); i++) {
            int tmp = str.charAt(i) - '0';
            // check if the number will overflow
            if (number > (Integer.MAX_VALUE - tmp) / 10)
                return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            number = number * 10 + tmp;
        }

        return isPositive? number : -number;
    }

    private boolean isDigit(char ch) {
        if(ch >= '0' && ch <= '9')
            return true;
        else
            return false;
    }
}
