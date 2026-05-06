class Solution {
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        if(root == null){
            return resultList;
        }
        TreeQueue queue = new TreeQueue();
        TreeNode curr = root;
        queue.append(curr);
        int levelCount = 1;
        int tmpCount;

        while(curr != null){
            List<Integer> currList = new ArrayList<>();
            tmpCount = 0;
            for(int i = 0; i < levelCount; i++){
                if(queue.top().left != null){
                    queue.append(queue.top().left);
                    tmpCount++;
                }
                if(queue.top().right != null){
                    queue.append(queue.top().right);
                    tmpCount++;
                }
                currList.add(queue.pop());
                if(queue.top == null){
                    curr = null;
                } else{
                    curr = queue.top();
                }
            }
            levelCount = tmpCount;
            resultList.add(currList);
        }
        
        return resultList;
    }    

    private class TreeQueue {
        ListNode top;
        ListNode tail;
    
        public TreeQueue() {
            top = null;
            tail = null;
        }
        
        public void append(TreeNode x) {
            ListNode tmp = new ListNode(x);
            if(top == null && tail == null){
                top = tmp;
                tail = tmp;
            } else {
                tail.next = tmp;
                tail = tail.next;
            }
        }
        
        public int pop() {
            TreeNode node = top.val;
            top = top.next;
            return node.val;
        }

        public TreeNode top() {
            return top.val;
        }
    
        private class ListNode {
            TreeNode val;
            ListNode next;
            ListNode(TreeNode val) { this.val = val; }
        }
    }

}