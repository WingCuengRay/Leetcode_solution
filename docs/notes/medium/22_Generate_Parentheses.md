# 22. Generate Parentheses (Medium)

## Description
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:
```
[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
```

link: https://leetcode.com/problems/generate-parentheses/


### Key Point
- Recursion
- Keep track of the number of open and closed parenthesis

P.S. Cannot solve the first before reading the solution.

### Anaylsis
TODO

#### Recursive Approach

#### Iterative Approach


## Solution
#### Recursive approach
Time: 1ms (faster than 93%)
Memory: 36.1MB (less than 100%)

```java
public class GenerateParentheses {

    private List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs("", n, n);
        return result;
    }


    public void dfs(String str, int left, int right) {
        if (left > right) {
            return;
        }

        if (left == 0 && right == 0) {
            result.add(str);
            return;
        }

        if (left > 0)
            dfs(str + "(", left - 1, right);
        if (right > 0)
            dfs(str + ")", left, right - 1);
    }
}
```

#### Iterative Solution
Time: 3ms (faster than 13.05%)
Memory: 36MB (less than 100%)

```java
package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yongcong Lei on 9/23/2019
 */
public class GenerateParentheses {
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
}

```