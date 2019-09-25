23. Merge k Sorted Lists (Hard)

## Description
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

**Example:**
```
Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
```

link: https://leetcode.com/problems/merge-k-sorted-lists/


### Key Point
- Derived from [21. Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/)
- merge Vertically or Horizontally
- binary merge with Divide and Conquer

### Anaylsis
TODO


## Solution
The solution is ranked by its performance (increasingly)
#### Merge horizontally and vertically
```java
public class MergeKSortedLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * Merge two list vertically
     * Time: 306 ms (faster than 7.38%)
     * Memory: 56.8MB (less than 5.47%)
     */
    public ListNode mergeKLists_Vertically(ListNode[] lists) {
        List<ListNode> arrLists = Arrays.stream(lists).filter(Objects::nonNull).collect(Collectors.toList());
        ListNode head = new ListNode(0);
        ListNode last = head;

        while (arrLists.size() > 0) {
            int idx = 0;
            int val = Integer.MAX_VALUE;
            for (int i = 0; i < arrLists.size(); i++) {
                if (arrLists.get(i).val < val) {
                    idx = i;
                    val = arrLists.get(i).val;
                }
            }

            last.next = arrLists.get(idx);
            last = last.next;

            ListNode tmp = arrLists.get(idx).next;
            if (tmp == null)
                arrLists.remove(idx);
            else
                arrLists.set(idx, tmp);
        }

        return head.next;
    }

    /**
     * Merge two list horizontally
     * Time: 107 ms (faster than 18.04%)
     * Memory: 56.8MB (less than 5.47%)
     */
    public ListNode mergeKLists_Horizontally(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;

        ListNode tmp = lists[0];
        for (int i = 1; i < lists.length; i++)
            tmp = merge2Lists(tmp, lists[i]);

        return tmp;
    }
    
    private ListNode merge2Lists(ListNode p1, ListNode p2) {
        ListNode head = new ListNode(0);
        ListNode tmp = head;

        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                tmp.next = p1;
                tmp = p1;
                p1 = p1.next;
            } else {
                tmp.next = p2;
                tmp = p2;
                p2 = p2.next;
            }
        }

        if (p1 != null)
            tmp.next = p1;
        else if (p2 != null)
            tmp.next = p2;

        return head.next;
    }
}
```

#### Binary merge with Divide and Conquer

```java
public class MergeKSortedLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

     /**
     * Merge two list non-recursively
     * Time: 3 ms (faster than 84.83%)
     * Memory: 42.3 MB (less than 29.51%)
     */
    public ListNode mergeKLists_NonRecursively(ListNode[] lists){
        if(lists == null || lists.length == 0)
            return null;

        List<ListNode> result = new LinkedList<>(Arrays.asList(lists));
        while (result.size() > 1) {
            List<ListNode> tmp = result;
            result = new ArrayList<>();

            for(int i=0; i < tmp.size(); i+=2) {
                if(i+1 < tmp.size())
                    result.add(merge2Lists(tmp.get(i), tmp.get(i+1)));
                else
                    result.add(tmp.get(i));
            }
        }

        return result.get(0);
    }

    /**
     * Merge two list recursively with Divide and Conquer
     * Time: 2 ms (faster than 99.12%)
     * Memory: 41.6MB (less than 37.71%)
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)
            return null;
        return merge(lists, 0, lists.length-1);
    }
    
    private ListNode merge(ListNode[] lists, int left, int right) {
        if(left == right)
            return lists[left];

        int mid = (left + right) / 2;

        ListNode leftHalf = merge(lists, left, mid);
        ListNode rightHalf = merge(lists, mid+1, right);
        return merge2Lists(leftHalf, rightHalf);
    }

    private ListNode merge2Lists(ListNode p1, ListNode p2) {
        ListNode head = new ListNode(0);
        ListNode tmp = head;

        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                tmp.next = p1;
                tmp = p1;
                p1 = p1.next;
            } else {
                tmp.next = p2;
                tmp = p2;
                p2 = p2.next;
            }
        }

        if (p1 != null)
            tmp.next = p1;
        else if (p2 != null)
            tmp.next = p2;

        return head.next;
    }
}

```