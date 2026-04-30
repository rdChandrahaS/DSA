import generator.TreeGenerator;
import model.TreeNode;

public class CheckIfTwoTreesAreIdenticalOrNot {
    boolean isIdentical(TreeNode root1,TreeNode root2){
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        if(root1.val != root2.val) return false;

        if(!isIdentical(root1.left, root2.left)) return false;
        if(!isIdentical(root1.right, root2.right)) return false;

        return true;
    }
    public static void main(String[] args) {
        CheckIfTwoTreesAreIdenticalOrNot obj = new CheckIfTwoTreesAreIdenticalOrNot();
        TreeNode root1 = new TreeGenerator().getRandomBinaryTree();
        TreeNode root2 = new TreeGenerator().getRandomBinaryTree();

        System.out.println("root1 & root1 are Identical : " + obj.isIdentical(root1, root1));
        System.out.println("root1 & root2 are Identical : " + obj.isIdentical(root1, root2));
    }
}
