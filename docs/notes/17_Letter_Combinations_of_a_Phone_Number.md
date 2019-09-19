# 17. Letter Combinations of a Phone Number (Medium)

## Description
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

![](../pics/17_Telephone-keypad2.png)

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.)

Example: 
```
Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
```

**Note:**
Although the above answer is in lexicographical order, your answer could be in any order you want.

link: https://leetcode.com/problems/letter-combinations-of-a-phone-number/

## Solution
```java
public class LetterCombination {
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty())
            return new ArrayList<>();

        List<String> result = new ArrayList<>();
        String first = getString(digits.charAt(0));
        for(char ch : first.toCharArray())
            result.add("" + ch);


        for(int i=1; i<digits.length(); i++){
            List<String> tmp = result;
            result = new ArrayList<>();

            String s = getString(digits.charAt(i));
            for(String str: tmp){
                for(char ch : s.toCharArray())
                    result.add(str + ch);
            }
        }

        return result;
    }

    private String getString(char ch){
        switch (ch){
            case '2':
                return "abc";
            case '3':
                return "def";
            case '4':
                return "ghi";
            case '5':
                return "jkl";
            case '6':
                return "mno";
            case '7':
                return "pqrs";
            case '8':
                return "tuv";
            case '9':
                return "wxyz";
            default:
                return "";
        }
    }
}
```
