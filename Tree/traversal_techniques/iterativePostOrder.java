package traversal_techniques;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import model.TreeNode;

public class iterativePostOrder {
    public List<Integer> iterativePostOrderTraversal(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        if(root == null) return ans;

        stack1.push(root);
        while(!stack1.isEmpty()){
            root = stack1.pop();

            stack2.add(root);
            if(root.left != null) stack1.push(root.left);
            if(root.right != null) stack1.push(root.right);
        }
        while(!stack2.isEmpty()){
            ans.add(stack2.pop().val);
        }
        return ans;
    }
}
