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
        return reverseListRec(head);
    }

    private static ListNode reverseListRec(ListNode node){
        ListNode newHead;
        if(node == null || node.next == null){
        } else {
            newHead = reverseListRec(node.next);
            node.next.next = node;
            node.next = null;
            node = newHead;
        }
        return node;
    }
}
