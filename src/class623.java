import java.util.ArrayDeque;
import java.util.Queue;
/**
 * 623. 在二叉树中增加一行
 * BFS
 * 1ms 24%
 */


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
public class class623 {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        Queue<TreeNode> que = new ArrayDeque<>();
        if (depth == 1) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        que.add(root);
        int nowDepth = 1;
        while (que.size() > 0) {
            int len = que.size();

            if (nowDepth == depth-1){
                for (int i = 0; i < len; i++) {
                    TreeNode node = que.poll();
                    TreeNode left = new TreeNode(val);
                    left.left = node.left;
                    TreeNode right = new TreeNode(val);
                    right.right = node.right;
                    node.left = left;
                    node.right = right;

                }
                break;
            }
            for (int i = 0; i < len; i++) {
                TreeNode node = que.poll();
                if (node.left!=null){
                    que.offer(node.left);
                }
                if (node.right !=null){
                    que.offer(node.right);
                }
            }

            nowDepth ++;
        }
        return root;
    }
}
