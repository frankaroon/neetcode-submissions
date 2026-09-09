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
    public ListNode reverseList(ListNode head) {
        // Base case: If the list is empty or only has one node, return head
        if (head == null || head.next == null) {
            return head;
        }

        // Recursive call: reverse the rest of the list
        ListNode newHead = reverseList(head.next);

        // Adjust the next pointers
        head.next.next = head; // Make the next node's next point to current node
        head.next = null;      // Set the current node's next to null (it will be the new tail)

        // Return the new head of the reversed list
        return newHead;
    }
}
