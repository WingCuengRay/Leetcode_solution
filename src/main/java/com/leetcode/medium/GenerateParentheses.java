package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yongcong Lei on 9/23/2019
 */
public class GenerateParentheses {

    private List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs("", n, n);
        return result;
    }


    private void dfs(String str, int left, int right) {
        if (left > right) {
            return;
        }

        if (left == 0 && right == 0) {
            result.add(str);
            return;
        }

        if (left > 0) {
            dfs(str + "(", left - 1, right);
        }
        if (right > 0) {
            dfs(str + ")", left, right - 1);
        }
    }

    class Record {
        private String str = new String();
        private int left;
        private int right;

        public Record(String str, int left, int right) {
            this.str = str;
            this.left = left;
            this.right = right;
        }

        public Record(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    public List<String> generateParenthesis_NonRecursive(int n) {
        List<String> localResult = new ArrayList<>();
        List<Record> records = new ArrayList<>();

        Record first = new Record(n, n);
        records.add(first);

        do {
            List<Record> tmp = records;
            records = new ArrayList<>();
            for (Record record : tmp) {
                if (record.left > record.right) {
                    continue;
                }
                if (record.left == 0 && record.right == 0) {
                    localResult.add(record.str);
                    continue;
                }

                if (record.left > 0){
                    Record newRecord = new Record(record.str+'(', record.left-1, record.right);
                    records.add(newRecord);
                }

                if(record.right > 0){
                    Record newRecord = new Record(record.str+')', record.left, record.right-1);
                    records.add(newRecord);
                }
            }
        } while (!records.isEmpty());

        return localResult;
    }

//    public List<String> generateParenthesis_Incorrect(int n) {
//        List<String> result = new ArrayList<>();
//
//        if (n == 0) {
//            return result;
//        }
//
//        result.add("()");
//        for (int i = 1; i < n; i++) {
//            List<String> tmp = result;
//            result = new ArrayList<>();
//
//            for (String str : tmp) {
//                String sideAppend = "(" + str + ")";
//                String leftAppend = "()" + str;
//                String rightAppend = str + "()";
//
//                if (!result.contains(sideAppend)) {
//                    result.add(sideAppend);
//                }
//                if (!result.contains(leftAppend)) {
//                    result.add(leftAppend);
//                }
//                if (!result.contains(rightAppend)) {
//                    result.add(rightAppend);
//                }
//            }
//        }
//
//        return result;
//    }

}
