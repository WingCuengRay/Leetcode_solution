# 8. String to Ingeger (Medium)

## Description
Implement atoi which converts a string to an integer.

The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned.

**Note:**
- Only the space character ' ' is considered as whitespace character.
- Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.

Example: 
```
Input: "   -42"
Output: -42
Explanation: The first non-whitespace character is '-', which is the minus sign.
             Then take as many numerical digits as possible, which gets 42.
```

```
Input: "4193 with words"
Output: 4193
Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
```

```
Input: "words and 987"
Output: 0
Explanation: The first non-whitespace character is 'w', which is not a numerical 
             digit or a +/- sign. Therefore no valid conversion could be performed.
```

```
Input: "-91283472332"
Output: -2147483648
Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
             Thefore INT_MIN (−231) is returned.
```

link: https://leetcode.com/problems/string-to-integer-atoi/

## Key point
The key point in this problem is to avoid overflow in transformation. The situation is similiar to [7. Reverse Integer](https://github.com/WingCuengRay/Leetcode_solution/blob/master/docs/notes/7_Reverse_Integer.md).
When transforming the string into integer, we always use the equation: `number = number * 10 + digit `. However, the result of
`number * 10 + digit` may overflow.

Someone may use `if(number * 10 + digit > Integer.MAX_VALUE)` to check the overflow, which **DOES NOT** work.  
The result of `number * 10 + digit` has already overflow before being compared to `Integer.MAX_VALUE`. 
As a result, we need to transform the equation above to avoid overflow. The improved check statement is 
`if(num > (Integer.MAX_VALUE-digit) / 10)`.

The addition and multiplication are transformed to subtraction and division to avoid overflow.

After the problem of overflow is solved, the problem becomes pretty easy. Just remember to check the **heading space**,
**heading '-' or '+'**, and the invalid characters.

## Solution
```
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
```
