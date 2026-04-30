import java.util.LinkedList;
import java.util.Queue;

import generator.TreeGenerator;
import model.TreeNode;

public class MaximumDepthInBinaryTree {
    private int solution(TreeNode root){
        if(root == null) return 0;

        int left = solution(root.left);
        int right = solution(root.right);

        return 1 + Math.max(left , right);
    }
    public static void main(String[] args) {
        MaximumDepthInBinaryTree sol = new MaximumDepthInBinaryTree();
        TreeNode root = new TreeGenerator().getRandomBinaryTree();
        System.out.println("Maximum Depth In BinaryTree (DFS) : " + sol.solution(root));
        System.out.println("Maximum Depth In BinaryTree (BFS) : " + sol.level_order_solution(root));
    }
    private int level_order_solution(TreeNode root){
        int ans = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) return ans;
        else queue.offer(root);

        while(!queue.isEmpty()){

            int len = queue.size();
            for(int i = 0 ; i < len ; i++){
                TreeNode curr = queue.poll();
                if(curr.left != null) queue.offer(curr.left);
                if(curr.right != null) queue.offer(curr.right);
            }

            ans++;
        }
        return ans;
    }
}
