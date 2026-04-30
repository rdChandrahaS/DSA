package traversal_techniques;

import java.util.ArrayList;
import java.util.List;

import model.TreeNode;

public class postOrder {
    public List<Integer> postOrderTraversal(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        (new postOrder()).postorder(root, ans);
        return ans;
    }
    private void postorder(TreeNode root,List<Integer> ans){
        if(root == null){
            return;
        }
        postorder(root.left, ans);
        postorder(root.right, ans);
        ans.add(root.val);
    }
}
