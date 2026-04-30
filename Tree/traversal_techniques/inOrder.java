package traversal_techniques;
import java.util.ArrayList;
import java.util.List;

import model.TreeNode;

public class inOrder {
    public List<Integer> inOrderTraversal(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        (new inOrder()).inorder(root, ans);
        return ans;
    }
    private void inorder(TreeNode root,List<Integer> ans){
        if(root == null){
            return;
        }
        inorder(root.left, ans);
        ans.add(root.val);
        inorder(root.right, ans);
    }
}
