/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class class110 {
    public boolean isBalanced(TreeNode root) {
        return DFS(root)!=-1;
    }
    private int DFS(TreeNode node){
        if (node == null) {
            return 0;
        }

        int left = DFS(node.left);
        if(left == -1){
            return  -1;
        }
        int right = DFS(node.right);
        if(right == -1){
            return  -1;
        }
        return Math.abs(left - right )<2? Math.max(left,right)+1:-1;
    }
}
