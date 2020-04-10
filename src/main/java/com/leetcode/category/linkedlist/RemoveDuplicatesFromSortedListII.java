package com.leetcode.category.linkedlist;

public class RemoveDuplicatesFromSortedListII {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * The idea is to have two pointers and make a fake head node in advanced for convenience in the case that the original head node should be removed (avoid too much if-else).
     *
     * In each iteration, we first check if the values in first point and the second pointer are equal.
     * If no, we can make sure the first node is unique and add it to our result list.
     * If yes, no node will be added to the list. We need to move forward the second pointer until its value is not equal to the node in first pointer. Then we update the first pointer and second pointer for next iteration.
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode first = head;
        ListNode second = head.next;
        ListNode newHead = new ListNode(Integer.MIN_VALUE);         // always make a fake head for convenience in the case that the original head node should be removed
        ListNode lastValid = newHead;

        newHead.next = head;
        while (first != null) {
            if (second == null || first.val != second.val) {
                lastValid.next = first;
                lastValid = first;
            } else {
                while (second != null && first.val == second.val) {
                    second = second.next;
                }
            }

            first = second;
            second = second == null ? null : second.next;
        }
        lastValid.next = null;

        return newHead.next;
    }
}
