class TreeMap {
    private TreeNode root;

    public TreeMap() {
        root = null;
    }

    public void insert(int key, int val) {
        if(root == null){
            root = new TreeNode(key, val);
            return;
        }

        TreeNode tmp = root;
        boolean inserted = false;

        while(!inserted){
            if(key < tmp.key){
                if(tmp.left == null){
                    tmp.left = new TreeNode(key, val);
                    inserted = true;
                } else{
                    tmp = tmp.left;
                }
            } else if(key > tmp.key){
                if(tmp.right == null){
                    tmp.right = new TreeNode(key, val);
                    inserted = true;
                } else{
                    tmp = tmp.right;
                }
            } else{
                tmp.val = val;
                inserted = true;
            }
        }
    }

    public int get(int key) {
        TreeNode tmp = root;
        while(tmp != null){
            if(key < tmp.key){
                tmp = tmp.left;
            } else if(key > tmp.key){
                tmp = tmp.right;
            } else{
                return tmp.val;
            }
        }
        return -1;
    }

    public int getMin() {
        if(root == null){
            return -1;
        }
        
        if(root.left == null && root.right == null){
            return root.val;
        }
        TreeNode tmp = root;
        while(tmp.left != null){
            tmp = tmp.left;
        }
        return tmp.val;
    }

    public TreeNode getMinNode(TreeNode node) {
        if(node.left == null && node.right == null){
            return node;
        }
        TreeNode tmp = node;
        while(tmp.left != null){
            tmp = tmp.left;
        }
        return tmp;
    }

    public int getMax() {
        if(root == null){
            return -1;
        }
        
        if(root.left == null && root.right == null){
            return root.val;
        }
        TreeNode tmp = root;
        while(tmp.right != null){
            tmp = tmp.right;
        }
        return tmp.val;
    }


    public void remove(int key) {
        if(root == null){
            return;
        }
        
        // Removing root
        if(key == root.key){
            if(root.left == null && root.right == null){
                root = null;
            } else if(root.left != null && root.right == null){
                root = root.left;
            } else if(root.left == null && root.right != null){
                root = root.right;
            } else{
                TreeNode min = getMinNode(root.right);
                remove(min.key);
                min.left = root.left;
                min.right = root.right;
                root = min;
            }
            return;
        }

        // Removing non-root
        TreeNode tmp = root;
        while(key != tmp.left.key && key != tmp.right.key){
            if(key < tmp.key){
                tmp = tmp.left;
            } else{
                tmp = tmp.right;
            }
        }

        if(key == tmp.left.key){
            TreeNode target = tmp.left;
            if(target.left == null && target.right == null){
                tmp.left = null;
            } else if(target.left != null && target.right == null){
                tmp.left = target.left;
            } else if(target.left == null && target.right != null){
                tmp.left = target.right;
            } else{
                TreeNode min = getMinNode(target.right);
                remove(min.key);
                min.left = target.left;
                min.right = target.right;
                tmp.left = min;
            }
        } else{
            TreeNode target = tmp.right;
            if(target.left == null && target.right == null){
                tmp.right = null;
            } else if(target.left != null && target.right == null){
                tmp.right = target.left;
            } else if(target.left == null && target.right != null){
                tmp.right = target.right;
            } else{
                TreeNode min = getMinNode(target.right);
                remove(min.key);
                min.left = target.left;
                min.right = target.right;
                tmp.right = min;
            }
        }
    }

    public List<Integer> getInorderKeys() {
        List<Integer> res = new ArrayList<>();
        getInorderRec(root, res);

        return res;
    }

    private void getInorderRec(TreeNode node, List<Integer> res){
        if(node != null){
            getInorderRec(node.left, res);
            res.add(node.key);
            getInorderRec(node.right, res);
        }
    }
}

class TreeNode {
    int key;
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}