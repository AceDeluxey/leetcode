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

/**
 * 563. 二叉树的坡度
 DFS
    0ms 100%
 */
public class class563 {
    int res = 0;

    public int findTilt(TreeNode root) {
        DFS(root);
        return res;
    }

    private int DFS(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = 0, right = 0;
        left = DFS(node.left);
        right = DFS(node.right);
        int des = Math.abs(left - right);
        res += des;
        return left + right + node.val;
    }
}
