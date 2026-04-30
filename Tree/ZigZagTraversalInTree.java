import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import generator.TreeGenerator;
import model.TreeNode;

public class ZigZagTraversalInTree {

    List<TreeNode> zigZagTraversalInTree(TreeNode root){
        List<TreeNode> ans = new ArrayList<>();
        if(root == null) return ans;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        ans.add(root);

        while(!queue.isEmpty()){
            
        }
        return ans;
    }
    public static void main(String[] args) {
        List<TreeNode> ans = (new ZigZagTraversalInTree()).zigZagTraversalInTree(new TreeGenerator().getRandomBinaryTree());
        System.out.println();
    }
}
