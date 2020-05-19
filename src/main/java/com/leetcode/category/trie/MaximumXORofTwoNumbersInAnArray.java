package com.leetcode.category.trie;

import java.util.ArrayList;
import java.util.List;

public class MaximumXORofTwoNumbersInAnArray {
    public class TrieNode {
        private TrieNode[] childs;
        private boolean isEnd;

        public TrieNode(boolean isEnd) {
            this.isEnd = isEnd;
            childs = new TrieNode[2];
        }

        public void insertString(final String bitsStr) {
            TrieNode currNode = this;

            for(char ch : bitsStr.toCharArray()) {
                if(currNode.childs[ch - '0'] == null) {
                    currNode.childs[ch - '0'] = new TrieNode(false);
                }

                currNode = currNode.childs[ch - '0'];
            }

            currNode.isEnd = true;
        }

        public int getMaxXORForNum(String bitsStr) {
            int currMaxXorVal = 0;
            TrieNode currNode = this;
            for(char ch : bitsStr.toCharArray()) {
                char opposite = ch == '0' ? '1' : '0';              // we want to get a child with the opposite value of the current bit from left-most to right-most
                if(currNode.childs[opposite - '0'] != null) {
                    currMaxXorVal = (currMaxXorVal << 1) | 1;       // we can set the current bit of max XOR value as 1 if we can find the opposite bit, 0 otherwise.
                    currNode = currNode.childs[opposite - '0'];
                } else {
                    currMaxXorVal = currMaxXorVal << 1;
                    currNode = currNode.childs[ch - '0'];
                }
            }

            return currMaxXorVal;
        }
    }

    public int findMaximumXOR(int[] nums) {
        int maxVal = Integer.MIN_VALUE;
        for(int num : nums) {
            maxVal = Math.max(maxVal, num);
        }

        final TrieNode root = new TrieNode(false);
        final List<String> bitStrArr = new ArrayList<>();
        int maxBitLen = Integer.toBinaryString(maxVal).length();
        for(int num : nums) {
            String bitStr = Integer.toBinaryString(num | (1 << maxBitLen)).substring(1);          // a way to zero padding 0 of the binary representation from the left-most side
            root.insertString(bitStr);

            bitStrArr.add(bitStr);
        }

        int maxXorVal = 0;
        for(String bitsString : bitStrArr) {
            maxXorVal = Math.max(maxXorVal, root.getMaxXORForNum(bitsString)); 
        }

        return maxXorVal;
    }

    public static void main(String ...args){
        MaximumXORofTwoNumbersInAnArray solution = new MaximumXORofTwoNumbersInAnArray();
        int nums[] = {3,10,5,25,2,8};
        
        int result = solution.findMaximumXOR(nums);
        System.out.println(result);
    }   
}