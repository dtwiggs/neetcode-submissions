/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if(root == null){
            return res;
        }


        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode tmp = queue.poll();

                if(i == 0){
                    res.add(tmp.val);
                }
                
                if(tmp.right != null){
                    queue.add(tmp.right);
                }

                if(tmp.left != null){
                    queue.add(tmp.left);
                }                
            }
        }

        return res;
    }
}
