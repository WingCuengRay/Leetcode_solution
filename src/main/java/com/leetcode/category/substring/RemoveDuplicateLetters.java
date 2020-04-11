package com.leetcode.category.substring;

import java.util.Stack;

public class RemoveDuplicateLetters {
    public class RemoveDuplicateLetters_Stack {
        public String removeDuplicateLetters(String s) {
            Stack<Character> stack =new Stack<>();
            boolean[] hasAdded = new boolean[26];
            char chArr[] = s.toCharArray();
            int chCnt[] = new int[26];

            for(char ch: chArr) {
                chCnt[ch - 'a']++;
            }

            int i = 0;
            while(i < chArr.length) {
                // we don't process the character if it's already in the stack
                if(!hasAdded[chArr[i] - 'a']) {
                    // we can see stack.peek() as s[i-1]
                    // if s[i-1] > s[i] and s[i-1] occurs later in the string, we can remove it safely and the result will not change
                    while((!stack.empty() && chArr[i] < stack.peek() && chCnt[stack.peek() - 'a'] > 1)) {
                        char toDel = stack.pop();
                        hasAdded[toDel - 'a'] = false;
                        chCnt[toDel - 'a']--;
                    }

                    stack.push(chArr[i]);
                    hasAdded[chArr[i] - 'a'] = true;
                } else {
                    chCnt[chArr[i] - 'a']--;
                }
                i++;
            }

            StringBuilder result = new StringBuilder();
            for(char ch : stack) {
                result.append(ch);
            }
            return result.toString();
        }
    }


    /**
     * The idea of this solution is to first find the "pivot" in the string. The "pivot" means the first position of a character that will never occur after this position (last occurrence).
     * Assume the index of the pivot is i, It means we need to find the smallest character in [0, i]
     * because each character must occur once in the result and we can't add s[i] (pivot) any more if we choose a smallest character after index i.
     *
     * On each iteration, we find a lexicographical smallest character in [0, i], say the index of this character is k.
     * Then we removed the smallest character in  [k+1, ...] and recursively find the next lexicographical character in the substring.
     *
     * Time Complexity: O(N^2)
     */
    public class RemoveDuplicateLetters_Recursive {
        public String removeDuplicateLetters(String s) {
            if (s == null || s.isEmpty()) {
                return "";
            }

            final int chCnt[] = new int[26];
            final char chArr[] = s.toCharArray();
            for (char ch : chArr) {
                chCnt[ch - 'a']++;
            }

            int smallestPos = 0;                // find the smallest character before the "pivot"
            for (int i = 0; i < chArr.length; i++) {
                if (chArr[i] < chArr[smallestPos]) {
                    smallestPos = i;
                }

                chCnt[chArr[i] - 'a']--;
                if (chCnt[chArr[i] - 'a'] == 0) {
                    break;
                }
            }                                   // i becomes the pivot after the iteration

            StringBuilder result = new StringBuilder();
            result.append(chArr[smallestPos]);
            result.append(removeDuplicateLetters(s.substring(smallestPos).replaceAll("" + chArr[smallestPos], "")));
            return result.toString();
        }
    }

}
