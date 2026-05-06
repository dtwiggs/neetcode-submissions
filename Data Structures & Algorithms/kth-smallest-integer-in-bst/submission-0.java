class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Helper helper = new Helper();
        kthSmallestRec(root, k, helper);
        return helper.target;
    }

    private static void kthSmallestRec(TreeNode node, int k, Helper helper){
        if(node == null || helper.i == k){
            return;
        }

        kthSmallestRec(node.left, k, helper);
        helper.i++;
        if(helper.i == k){
            helper.target = node.val;
            return;
        }
        kthSmallestRec(node.right, k, helper);
    }

    private static class Helper{
        int i = 0;
        int target = 0;
    }
}
