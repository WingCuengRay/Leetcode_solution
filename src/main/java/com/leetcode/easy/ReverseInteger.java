package com.leetcode.easy;

/**
 * Created by Yongcong Lei on 8/23/2019
 */
public class ReverseInteger {

    /**
     * using math operation to check if the partly reversed number overlflows
     *
     * Time: 1 ms
     * Memory: 33.4 MB
     */
    public static int reverseWithMath(int x){
        int result = 0;
        // better to convert the x to long and then do the abs operation
        // because Math.abs(Integer.MIN_VALUE) == Integer.MIN_VALUE
        long y = Math.abs((long)x);

        while(y != 0){
            int mod = (int)(y % 10);
            y = y/10;

            // Overflow may happen here if result > MAX_INTEGER
            // so we need to check in advanced
            // result = result * 10 + mod;
            if((Integer.MAX_VALUE - mod)/10 < result)
                return 0;
            result = result*10 + mod;
        }

        return x>0? result: -result;
    }

    /**
     * using String to reverse the integer
     *
     * Time: 2 ms
     * Memory: 34.2 MB
     */
    public static int reverseWithString(int x) {
        boolean isNegative = (x < 0)? true: false;
        String value = new StringBuilder(String.valueOf(Math.abs((long)x))).reverse().toString();
        String maxInt = String.valueOf(isNegative? Integer.MAX_VALUE-1: Integer.MAX_VALUE);

        int i = 0;
        while(i < value.length()){
            if(value.charAt(i) == '0')
                i++;
            else
                break;
        }
        value = value.substring(i);     // trim heading '0'
        if(value.isEmpty())
            value = "0";

        if(value.length() > maxInt.length())
            return 0;
        else if(value.length() < maxInt.length())
            return Integer.parseInt((isNegative? "-" : "") + value);
        else {
            for(int j=0; j<value.length(); j++){
                if(value.charAt(j) > maxInt.charAt(j))
                    return 0;
                else if(value.charAt(j) < maxInt.charAt(j))
                    break;
            }
        }

        return Integer.parseInt((isNegative? "-" : "") + value);
    }

}
