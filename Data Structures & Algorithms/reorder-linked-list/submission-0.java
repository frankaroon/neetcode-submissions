/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        // find the middle
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse the linked list
        ListNode curr = slow; 
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // merge the two lists
        ListNode l1 = head;
        ListNode l2 = prev;
        while (l2.next != null) {
            ListNode tmp = l1.next;
            l1.next = l2;
            l1 = tmp;

            tmp = l2.next;
            l2.next = l1;
            l2 = tmp;
        }
    }
}
