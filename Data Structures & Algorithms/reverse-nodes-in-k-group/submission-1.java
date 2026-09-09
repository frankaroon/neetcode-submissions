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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode groupPrev = dummy;
        while (true) {
            ListNode kth = getKth(groupPrev, k);
            if (kth == null) break;

            // set ptr to the next group
            ListNode groupNext = kth.next;
            
            // reverse current group
            ListNode prev = kth.next;
            ListNode curr = groupPrev.next;
            while (curr != groupNext) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            // update the groupPrev to the the first node in current group
            // then shift groupPrev to be the last node in current group
            ListNode next = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = next;
        }

        return dummy.next;
    }

    public ListNode getKth(ListNode curr, int k) {
        while (k-- != 0 && curr != null) {
            curr = curr.next;
        }
        return curr;
    }
}