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
        if (head != null && head.next != null){
            head = reverseListRec(head);
        }
        return head;
    }

    private static ListNode reverseListRec(ListNode node){
        if (node.next == null){
        }
        else {
            ListNode newHead = reverseListRec(node.next);
            node.next.next = node;
            node.next = null;
            node = newHead;
        }
        return node;
    }
}