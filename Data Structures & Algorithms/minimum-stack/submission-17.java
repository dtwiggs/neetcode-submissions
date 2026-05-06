class MinStack {
    ListNode curr;
    ListNode min;

    public MinStack() {
        curr = null;
        min = null;
    }
    
    public void push(int val) {
        if(curr == null){
            curr = new ListNode(val);
            min = new ListNode(val);
        } else{
            ListNode tmp = curr;
            curr = new ListNode(val);
            curr.prev = tmp;

            if(val < min.val){
                tmp = min;
                min = new ListNode(val);
                min.prev = tmp;
            } else{
                tmp = min;
                min = new ListNode(min.val);
                min.prev = tmp;
            }
        }
    }
    
    public void pop() {
        if(curr.prev != null){
            curr = curr.prev;
            min = min.prev;
        } else {
            curr = null;
            min = null;
        }
    }
    
    public int top() {
        return curr.val;
    }
    
    public int getMin() {
        return min.val;
    }

    private class ListNode {
        int val;
        ListNode prev;
        ListNode() {};
        ListNode(int val) { this.val = val; }
    }
}