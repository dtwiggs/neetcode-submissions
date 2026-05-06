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
    public ListNode mergeKLists(ListNode[] lists) {
        int interval = 1;

        if(lists.length == 0){
            return null;
        } else if(lists.length == 1){
            return lists[0];
        }

        while(interval < lists.length){
            int i = 0;
            while((i  + interval) < lists.length){
                lists[i] = merge(lists[i], lists[i + interval]);
                i += 2 * interval;
            }
            interval *= 2;
        }

        return lists[0];
    }


    private ListNode merge(ListNode a, ListNode b){
        if(a == null){
            return b;
        } else if(b == null){
            return a;
        }

        ListNode tmp = new ListNode(-1);
        ListNode dummy = tmp;

        while(a != null && b != null){
            if(a.val <= b.val){
                tmp.next = a;
                a = a.next;
                tmp = tmp.next;
            } else{
                tmp.next = b;
                b = b.next;
                tmp = tmp.next;
            }
        }

        if(a == null){
            while(b != null){
                tmp.next = b;
                b = b.next;
                tmp = tmp.next;
            }
        } else{
            while(a != null){
                tmp.next = a;
                a = a.next;
                tmp = tmp.next;
            }
        }

        return dummy.next;
    }
}
