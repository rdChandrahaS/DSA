package generator;

import model.TreeNode;
import generator.core.TreeFactory;
import generator.visualizer.TreeVisualizer;
public class TreeGenerator {
    
    public TreeNode generate() {
        TreeFactory factory = new TreeFactory();
        TreeNode root = factory.buildComplexTree();

        System.out.println("Tree generated successfully! Launching Java Visualizer...");

        TreeVisualizer.showTree(root);

        return root;
    }
}