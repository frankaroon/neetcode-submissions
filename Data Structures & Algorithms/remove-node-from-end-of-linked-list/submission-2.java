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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head; 

        ListNode prev = dummy;
        ListNode end = dummy;
        while (n-- >= 0) {
            end = end.next;             
        }   

        while (end != null) {
            prev = prev.next;
            end = end.next;
        }

        prev.next = prev.next.next;

        return dummy.next;
    }
}
