class Solution {
    private int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root;

        if(preorder.length == 0 || inorder.length == 0){
            root = null;
        } else {
            root = buildTreeRec(preorder, inorder, 0, inorder.length - 1);
        }

        return root;
    }

    private TreeNode buildTreeRec(int[] preorder, int[] inorder, int inStart, int inEnd){
        TreeNode node;
        if(inStart > inEnd){
            return null;
        }

        node = new TreeNode(preorder[preIndex]);
        preIndex++;

        if(inStart == inEnd){
            return node;
        }
        
        int inIndex = findIndex(inorder, inStart, inEnd, node.val);
        node.left = buildTreeRec(preorder, inorder, inStart, inIndex - 1);
        node.right = buildTreeRec(preorder, inorder, inIndex + 1, inEnd);

        return node;
    }

    private int findIndex(int[] inorder, int inStart, int inEnd, int value){
        int index = -1;
        for(int i = inStart; i <= inEnd; i++){
            if(inorder[i] == value){
                index = i;
            }
        }
        return index;
    }

}
