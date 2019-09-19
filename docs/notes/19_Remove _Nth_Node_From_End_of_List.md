# 19. Remove Nth Node From End of List (Medium)

## Description
Given a linked list, remove the n-th node from the end of list and return its head.

Example: 
```
Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
```

**Note:**

Given n will always be valid.

**Follow up:**

Could you do this in one pass?

link: https://leetcode.com/problems/remove-nth-node-from-end-of-list/

## Solution
```java
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
```
