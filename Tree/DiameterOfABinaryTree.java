import generator.TreeGenerator;
import model.TreeNode;

public class DiameterOfABinaryTree {
    static int ans;
    public static void main(String[] args) {
        TreeNode root = new TreeGenerator().getRandomBinaryTree();
        ans = 0;
        int maxDepth = (new DiameterOfABinaryTree()).diameter(root);
        System.out.println("Diameter of the tree : " + ans);
    }

    int diameter(TreeNode root) {
        if(root == null) return 0;

        int leftRadius = diameter(root.left);
        int rightRadius = diameter(root.right);
        
        /**
         * In this, the edges are considered, not vertices
         */
        ans = Math.max(leftRadius + rightRadius, ans); 

        return 1 + Math.max(leftRadius , rightRadius);
    }
}
