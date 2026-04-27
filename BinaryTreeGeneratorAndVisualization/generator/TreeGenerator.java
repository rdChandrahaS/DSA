package generator;

import model.TreeNode;
import generator.core.TreeFactory;
import generator.visualizer.TreeVisualizer;

/**
 * A utility class for generating and visually displaying Binary Trees.
 */
public class TreeGenerator {
    
    private TreeFactory factory;

    public TreeGenerator() {
        this.factory = new TreeFactory();
    }

    /**
     * Generates a complex, unbalanced random binary tree.
     * Useful for testing edge cases in traversals.
     * @return The root node of the generated tree.
     */
    public TreeNode getRandomBinaryTree() {
        TreeNode root = factory.buildComplexTree();

        System.out.println("Tree generated successfully! Launching Java Visualizer...");
        TreeVisualizer.showTree(root);

        return root;
    }
}