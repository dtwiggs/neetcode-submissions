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
        if (head == null || head.next == null){
        } else {
            head = reverseListRec(head);
        }
        return head;
    }

    public ListNode reverseListRec(ListNode node){
        if(node.next == null){
            return node;
        }
        ListNode newHead = reverseListRec(node.next);
        node.next.next = node;
        node.next = null;
        return newHead;
    }
}
