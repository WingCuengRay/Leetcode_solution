package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yongcong Lei on 9/18/2019
 */
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
