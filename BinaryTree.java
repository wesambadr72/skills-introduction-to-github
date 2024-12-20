class BinaryTree {
    TreeNode root;

    BinaryTree() {
        root = null;
    }

    void add(int value) {
        root = addRecursive(root, value);
    }

    TreeNode addRecursive(TreeNode root, int value) {
        if (root == null) {
            root = new TreeNode(value);
            return root;
        }
        if (value < root.value) {
            root.left = addRecursive(root.left, value);
        } else if (value > root.value) {
            root.right = addRecursive(root.right, value);
        }
        return root;
    }

    void delete(int value) {
        root = deleteRecursive(root, value);
    }

    TreeNode deleteRecursive(TreeNode root, int value) {
        if (root == null) {
            return root;
        }
        if (value < root.value) {
            root.left = deleteRecursive(root.left, value);
        } else if (value > root.value) {
            root.right = deleteRecursive(root.right, value);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.value = findSmallestValue(root.right);
            root.right = deleteRecursive(root.right, root.value);
        }
        return root;
    }

    boolean search(int value) {
        return searchRecursive(root,value);
    }

    boolean searchRecursive(TreeNode root, int value) {
        if (root == null) {
            return false;
        }
        if (value == root.value) {
            return true;
        }
        return value < root.value ? searchRecursive(root.left, value) : searchRecursive(root.right, value);
    }

    int size() {
        return sizeRecursive(root);
    }

    int sizeRecursive(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return sizeRecursive(root.left) + 1 + sizeRecursive(root.right);
        }
    }

    void inOrder() {
        inOrderRecursive(root);
    }

    void inOrderRecursive(TreeNode root) {
        if (root != null) {
            inOrderRecursive(root.left);
            visit(root);
            inOrderRecursive(root.right);
        }
    }

    void postOrder(){
        postOrderRecursive(root);
    }
    void postOrderRecursive(TreeNode root) {
        if (root!=null) {
            postOrderRecursive(root.left);
            postOrderRecursive(root.right);
            visit(root);
        }
    }

    void preOrder() {
        preOrderRecursive(root);
    }

    void preOrderRecursive(TreeNode root) {
        if (root != null) {
            visit(root);
            preOrderRecursive(root.left);
            preOrderRecursive(root.right);
        }
    }

    void visit(TreeNode node) {
        System.out.print(node.value + " ");

    }

    int findSmallestValue(TreeNode root) {
        return root.left == null ? root.value : findSmallestValue(root.left);
    }

    boolean isEmpty() {
        return root == null;
    }

  

}
