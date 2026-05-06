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
        ListNode prev = null;
        ListNode tmp = null;

        if(head == null){
            return head;
        }

        while(head.next != null){
            tmp = head.next;
            head.next = prev;
            prev = head;

            head = tmp;
        }
        if(head != null){
            head.next = prev;
        }

        return head;
    }
}
