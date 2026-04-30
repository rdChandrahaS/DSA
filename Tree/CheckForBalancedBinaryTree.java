import generator.TreeGenerator;
import model.TreeNode;

/**
 * A Binary Tree is said to be a Balanced Binary Tree if
 * for every 
 *          height(left) - height(right) <= 1
 */
public class CheckForBalancedBinaryTree {
    boolean isBalancedBinaryTree(TreeNode root){
        return height(root) == -1;
    }

    int height(TreeNode root) {

        if(root == null) return 0;

        int left = height(root.left);
        if(left == -1) return -1;

        int right = height(root.right);
        if(right == -1) return -1;

        if(left - right > 1) return -1;

        return Math.max(left, right) + 1;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeGenerator().getRandomBinaryTree();
        System.out.println("Is Balanced Binary Tree ? : " + (new CheckForBalancedBinaryTree()).isBalancedBinaryTree(root));
    }
}
