import generator.TreeGenerator;
import model.TreeNode;

public class MaximumPathSumInBinaryTree {
    static int currMax;
    int maximumPathSum(TreeNode root){
        if(root == null) return 0;

        int leftMax = Math.max(maximumPathSum(root.left) , 0);
        int rightMax = Math.max(maximumPathSum(root.right) , 0);

        currMax = Math.max(currMax , root.val + leftMax + rightMax);

        return Math.max(leftMax , rightMax) + root.val;
    }
    public static void main(String[] args) {
        (new MaximumPathSumInBinaryTree()).maximumPathSum((new TreeGenerator()).getRandomBinaryTree());
        System.out.println("Maximum Path Sum : " + currMax);
    }
}
