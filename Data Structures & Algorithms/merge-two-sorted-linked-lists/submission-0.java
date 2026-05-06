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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = null;
        ListNode newNode = null;

        if(list1 == null){
            return list2;
        } else if(list2 == null){
            return list1;
        }
        
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                if(head == null){
                    newNode = list1;
                    head = newNode;
                    list1 = list1.next;
                } else{
                    newNode.next = list1;
                    list1 = list1.next;
                    newNode = newNode.next;
                }
            } else{
                if(head == null){
                    newNode = list2;
                    head = newNode;
                    list2 = list2.next;
                } else{
                    newNode.next = list2;
                    list2 = list2.next;
                    newNode = newNode.next;
                }
            }
        }

        if(list1 != null){
            newNode.next = list1;
        } else if(list2 != null){
            newNode.next = list2;
        }

        return head;
    }
}