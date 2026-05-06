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
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode fast = head, slow = new ListNode(-1, head);

        while(slow != fast && fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        if(fast == null || fast.next == null){
            return false;
        }

        return true;
    }
}
