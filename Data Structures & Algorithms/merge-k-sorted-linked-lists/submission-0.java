
 class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = null;

        if(lists.length == 0){
        } else if(lists.length == 1){
            result = lists[0];
        } else{
            for(int i = 0; i < lists.length - 1; i++){
                result = merge(lists[i], lists[i + 1]);
                lists[i + 1] = result;
            }
        }

        return result;
    }

    private ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                curr.next = l1;
                l1 = l1.next;
            } else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        if(l1 != null){
            curr.next = l1;
        } else{
            curr.next = l2;
        }

        return dummy.next;
    }

}
