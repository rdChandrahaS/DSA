package traversal_techniques;

import java.util.ArrayList;
import java.util.List;

import model.TreeNode;

public class preOrder {
    public List<Integer> preOrderTraversal(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        (new preOrder()).preorder(root, ans);
        return ans;
    }
    private void preorder(TreeNode root,List<Integer> ans){
        if(root == null){
            return;
        }
        ans.add(root.val);
        preorder(root.left, ans);
        preorder(root.right, ans);
    }
}
