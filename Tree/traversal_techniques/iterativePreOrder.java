package traversal_techniques;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import model.TreeNode;

public class iterativePreOrder {
    public List<Integer> iterativePreOrderTraversal(TreeNode root){
        List<Integer> ans = new ArrayList<>();

        if(root == null) return ans;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while(!stack.isEmpty()){
            TreeNode top = stack.pop();
            ans.add(top.val);
            if(top.right != null) stack.push(top.right);
            if(top.left != null) stack.push(top.left);
        }
        return ans;
    }
}