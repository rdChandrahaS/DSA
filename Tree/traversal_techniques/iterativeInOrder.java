package traversal_techniques;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import model.TreeNode;

public class iterativeInOrder {
    public List<Integer> iterativeInOrderTraversal(TreeNode root){
        List<Integer> ans = new ArrayList<>();

        if(root == null) return ans;
        
        Stack<TreeNode> stack = new Stack<>();
        while(true){
            if(root != null){
                stack.push(root);
                root = root.left;
            }else{
                if(stack.isEmpty()){
                    break;
                }
                root = stack.pop();
                ans.add(root.val);
                root = root.right;
            }
        }
        return ans;
    }
}
