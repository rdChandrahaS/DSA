package model;

/**
 * int val
 * TreeNode left
 * TreeNode right
 * 
 * public TreeNode(){}
 * public TreeNode(int _val){val = _val;}
 * public TreeNode(int _val,TreeNode _right,TreeNode _left){
 *      val = _val;
 *      this.right = _right;
 *      this.left = _left;
 * }
 */
public class TreeNode{
    public int val;
    public TreeNode left;
    public TreeNode right;
    
    public TreeNode(){}
    public TreeNode(int _val){val = _val;}
    public TreeNode(int _val,TreeNode _right,TreeNode _left){
        val = _val;
        this.right = _right;
        this.left = _left;
    }
}
