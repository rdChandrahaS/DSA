import model.TreeNode;

import generator.TreeGenerator;
import traversal_techniques.*;
import utility.WorkspaceCleaner;

public class GraphTraversal {
    public static void main(String[] args) {
        
        TreeGenerator generator = new TreeGenerator();
        TreeNode root = generator.getRandomBinaryTree(); 
        
        System.out.println("Post Order : " + (new postOrder()).postOrderTraversal(root));
        System.out.println("In Order : " + (new inOrder()).inOrderTraversal(root));
        System.out.println("Pre Order : " + (new preOrder()).preOrderTraversal(root));
        System.out.println("Iterative Pre Order : " + (new iterativePreOrder()).iterativePreOrderTraversal(root));
        System.out.println("Iterative In Order : " + (new iterativeInOrder()).iterativeInOrderTraversal(root));
        System.out.println("Iterative Post Order : " + (new iterativePostOrder()).iterativePostOrderTraversal(root));
        
        WorkspaceCleaner.clean();
    }
}