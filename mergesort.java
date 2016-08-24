/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {      
    public ListNode sortList(ListNode head) {
        //check if null, return head
        if (head == null || head.next == null) {
            return head;
        } else {
            ListNode mid = getMiddle(head);
            ListNode right = sortList(mid.next);
            mid.next = null;
            ListNode left = sortList(head);

            return merge(left, right); 
        }
    }
    
    private ListNode getMiddle(ListNode l) {
        ListNode slow = l, fast = l.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }    

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        if (l1 != null) {
            tail.next = l1;
        } else {
            tail.next = l2;
        }

        return dummy.next;
    }
}
