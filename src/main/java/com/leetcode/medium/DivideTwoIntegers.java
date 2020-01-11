package com.leetcode.medium;

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        int sign = (dividend > 0) ^ (divisor > 0) ? -1 : 1;

        long l_dividend = Math.abs((long) dividend);
        long l_divisor = Math.abs((long) divisor);

        // dividend = divisor * quotient + remainder
        // dividend = divisor * quotient
        int i = 31;
        while(i >= 0) {
            if((l_divisor << i) < l_dividend)
                break;
            i--;
        }

        return sign * i;
    }
}
