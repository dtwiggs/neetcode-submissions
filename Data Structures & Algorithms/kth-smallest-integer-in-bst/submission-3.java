class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int[] tmp = new int[2];
        tmp[0] = k;
        kthSmallestRec(root, tmp);
        return tmp[1];
    }

    public void kthSmallestRec(TreeNode node, int[] tmp){
        if(node == null){
            return;
        }

        kthSmallestRec(node.left, tmp);
        tmp[0]--;
        if(tmp[0] == 0){
            tmp[1] = node.val;
        }
        kthSmallestRec(node.right, tmp);

        return;
    }
}
