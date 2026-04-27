package generator.core;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import model.TreeNode;

public class TreeFactory {

    public TreeNode buildComplexTree() {
        TreeNode root = new TreeNode(1);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        int valCounter = 2;
        
        int maxNodes = new Random().nextInt(50) + 1; 
        System.out.println("TreeFactory: Generating a tree with approximately " + maxNodes + " nodes.");
        
        if (maxNodes == 1) return root;
        
        while (!queue.isEmpty() && valCounter <= maxNodes) {
            TreeNode current = queue.poll();
            
            if (valCounter % 7 != 0) { 
                current.left = new TreeNode(valCounter++);
                queue.add(current.left);
            } else {
                valCounter++; 
            }
            
            if (valCounter > maxNodes) break;
            
            if (valCounter % 5 != 0) { 
                current.right = new TreeNode(valCounter++);
                queue.add(current.right);
            } else {
                valCounter++;
            }
        }
        
        TreeNode deepNode = root;
        while (deepNode.left != null) {
            deepNode = deepNode.left;
        }
        
        int zigZagCounter = 0;
        while (valCounter <= maxNodes && zigZagCounter < 15) {
            deepNode.left = new TreeNode(valCounter++);
            deepNode = deepNode.left;
            zigZagCounter++;
            
            if (zigZagCounter % 2 == 0 && valCounter <= maxNodes) {
                deepNode.right = new TreeNode(valCounter++);
                valCounter++;
            }
        }
        
        return root;
    }
}