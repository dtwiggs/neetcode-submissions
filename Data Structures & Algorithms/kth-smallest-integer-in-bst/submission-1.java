class Solution {
    private int i = 0;
    private int target = 0;

    public int kthSmallest(TreeNode root, int k) {
        kthSmallestRec(root, k);
        return target;
    }

    private void kthSmallestRec(TreeNode node, int k){
        if(node == null){
            return;
        }
        kthSmallestRec(node.left, k);
        i++;
        if(i == k){
            target = node.val;
            return;
        }
        kthSmallestRec(node.right, k);
    }
}
