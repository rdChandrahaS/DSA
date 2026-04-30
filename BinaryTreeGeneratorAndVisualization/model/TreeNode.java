package model;

import java.util.Objects;

/**
 * Definition for a binary tree node.
 * <pre>
 * public class TreeNode {
 *      int val;
 *      TreeNode left;
 *      TreeNode right;
 *      TreeNode() {}
 *      TreeNode(int val) { this.val = val; }
 *      TreeNode(int val, TreeNode left, TreeNode right) {
 *          this.val = val;
 *          this.left = left;
 *          this.right = right;
 *      }
 * }
 * </pre>
 */
public class TreeNode {
    /** The value stored in the node. */
    public int val;
    /** Pointer to the left child node. */
    public TreeNode left;
    /** Pointer to the right child node. */
    public TreeNode right;
    
    public TreeNode() {}
    
    public TreeNode(int _val) { 
        this.val = _val; 
    }
    
    public TreeNode(int _val, TreeNode _left, TreeNode _right) {
        this.val = _val;
        this.left = _left;
        this.right = _right;
    }

    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode treeNode = (TreeNode) o;
        return val == treeNode.val;
    }

    @Override
    public int hashCode() {
        return Objects.hash(val);
    }

    @Override
    public String toString() {
        return String.valueOf(this.val);
    }
}