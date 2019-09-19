package com.leetcode.medium;

/**
 * Created by Yongcong Lei on 9/18/2019
 */
public class RemoveNthNodeFromEndofList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * Add a dummpy node in the head of the list.
     * Do not need to deal with the case that head should be deleted.
     */
    public ListNode removeNthFromEndWithDummyNode(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode first, second;
        first = dummy;
        second = head;

        for(int i=0; i<n; i++){
            if(second == null)
                return null;
            second = second.next;
        }

        while(second != null){
            first = first.next;
            second = second.next;
        }

        first.next = first.next.next;
        return dummy.next;
    }

    /**
     * No dummpy node is added.
     * Need to check if the first pointer is the head. If it is, set the head pointer to its next node.
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first, second, pre = null;

        first = second = head;
        for(int i=0; i<n; i++){
            if(second == null)
                return head;
            second = second.next;
        }

        while(second != null){
            pre = first;
            first = first.next;
            second = second.next;
        }

        if(first == null)
            return head;
        else if(first == head)
            head = first.next;
        else
            pre.next = first.next;
        return head;
    }
}
