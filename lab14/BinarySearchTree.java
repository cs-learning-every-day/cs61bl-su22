public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> {

    /* Creates an empty BST. Super() calls the constructor for BinaryTree (not in scope). */
    public BinarySearchTree() {
        super();
    }

    /* Creates a BST with root as ROOT. */
    public BinarySearchTree(TreeNode root) {
        super(root);
    }

    /* Returns true if the BST contains the given KEY. */
    public boolean contains(T key) {
        // YOUR CODE HERE
        return contains(root, key);
    }

    private boolean contains(TreeNode node, T key) {
        // YOUR CODE HERE

        if (node == null) {
            return false;
        }
        int cmp = node.item.compareTo(key);
        if (cmp == 0) {
            return true;
        } else if (cmp < 0) {
            return contains(node.right, key);
        } else {
            return contains(node.left, key);
        }
    }


    /* Adds a node for KEY iff KEY isn't in the BST already. */
    public void add(T key) {
        // YOUR CODE HERE
        root = add(root, key);
    }

    private TreeNode add(TreeNode node, T key) {
        if (node == null) {
            return new TreeNode(key);
        }

        int cmp = node.item.compareTo(key);

        if (cmp < 0) {
            node.right = add(node.right, key);
        } else if (cmp > 0) {
            node.left = add(node.left, key);
        }
        return node;
    }

    /* Deletes a node from the BST.
     * Even though you do not have to implement delete, you
     * should read through and understand the basic steps.
     */
    public T delete(T key) {
        TreeNode parent = null;
        TreeNode curr = root;
        TreeNode delNode = null;
        TreeNode replacement = null;
        boolean rightSide = false;

        while (curr != null && !curr.item.equals(key)) {
            if (curr.item.compareTo(key) > 0) {
                parent = curr;
                curr = curr.left;
                rightSide = false;
            } else {
                parent = curr;
                curr = curr.right;
                rightSide = true;
            }
        }
        delNode = curr;
        if (curr == null) {
            return null;
        }

        if (delNode.right == null) {
            if (root == delNode) {
                root = root.left;
            } else {
                if (rightSide) {
                    parent.right = delNode.left;
                } else {
                    parent.left = delNode.left;
                }
            }
        } else {
            curr = delNode.right;
            replacement = curr.left;
            if (replacement == null) {
                replacement = curr;
            } else {
                while (replacement.left != null) {
                    curr = replacement;
                    replacement = replacement.left;
                }
                curr.left = replacement.right;
                replacement.right = delNode.right;
            }
            replacement.left = delNode.left;
            if (root == delNode) {
                root = replacement;
            } else {
                if (rightSide) {
                    parent.right = replacement;
                } else {
                    parent.left = replacement;
                }
            }
        }
        return delNode.item;
    }
}
