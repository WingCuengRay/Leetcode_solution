package com.leetcode.medium;

/**
 * Created by Yongcong Lei on 8/29/2019
 */
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
