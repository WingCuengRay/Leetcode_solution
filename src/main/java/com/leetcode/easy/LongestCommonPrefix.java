package com.leetcode.easy;

/**
 * Created by Yongcong Lei on 8/29/2019
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        else if(strs.length == 1)       // return itself if there is only one string
            return strs[0];

        for(String str: strs){
            if(str.isEmpty())
                return "";
        }

        int i = 0;

        outerloop:
        while(true){
            if(i >= strs[0].length())
                break;
            char ch = strs[0].charAt(i);
            for(String str : strs){
                if(i>=str.length() || str.charAt(i) != ch)
                    break outerloop;
            }
            i++;
        }

        return strs[0].substring(0, i);
    }

    public String longestCommonPrefix_2nd(String[] strs){
        if(strs.length == 0)
            return "";
        else if(strs.length == 1)
            return strs[0];

        String commonPrefix = strs[0];
        for(int i=1; i<strs.length; i++){
            commonPrefix = longestCommonPrefix(commonPrefix, strs[i]);
            if(commonPrefix.isEmpty())
                return "";
        }

        return commonPrefix;
    }

    private String longestCommonPrefix(String str1, String str2){
        /**
        // don't know why, the code here is faster than the code below in leetcode running environment
        while(!str1.startsWith(str2)){
            str2=str2.substring(0,str2.length()-1);
        }
        return str2;
         **/
        int i;
        for(i=0; i<str1.length() && i< str2.length(); i++){
            if(str1.charAt(i) != str2.charAt(i))
                break;
        }

        return str1.substring(0, i);
    }
}
