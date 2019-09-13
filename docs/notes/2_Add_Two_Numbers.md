# 2. Add Two Numbers (Medium)
 
## Description
> You are given two **non-empty** linked lists representing two non-negative integers. The digits are stored in **reverse order** and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
> You may assume the two numbers do not contain any leading zero, except the number 0 itself.

## Analysis
### Special case
1. If the sum of digits in two node greater than 10, the decimal value (`sum/10`) should be added into the next node.
2. If the sum of last node(s) are greater than 10, an extra node should be append to the result list. The value
of the new node is just the decimal value of the sum in last round.
3. The sum should can be comprised of a node in first list, a node in second list and the decimal value of previous sum.
Meanwhile, it's possible that the node in either first or second list is missing.

## Implmentation
```java
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode first = l1;
        ListNode second = l2;
        ListNode head = new ListNode(0);
        ListNode curNode = head;

        int overadd = 0;
        while(first!=null || second!=null) {
            if(first!=null && second!=null){
                int sum = first.val + second.val + overadd;

                ListNode newNode = new ListNode(sum % 10);
                curNode.next = newNode;
                curNode = newNode;

                overadd = sum / 10;
                first = first.next;
                second = second.next;
            } else if(first == null) {
                int sum = second.val + overadd;

                ListNode newNode = new ListNode(sum % 10);
                curNode.next = newNode;
                curNode = newNode;

                overadd = sum/10;
                second = second.next;
            } else {
                int sum = first.val + overadd;

                ListNode newNode = new ListNode(sum % 10);
                curNode.next = newNode;
                curNode = newNode;

                overadd = sum/10;
                first = first.next;
            }
        }

        // this case is missing in the first submission!
        if(overadd != 0)
            curNode.next = new ListNode(overadd);

        return head.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
```