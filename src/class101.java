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

/**
 * 101. 对称二叉树
 * 就用左边验证右边就好了
 * 0ms 100%
 */
public class class101 {
    boolean flag = true;
    public boolean isSymmetric(TreeNode root) {
        DFS(root.left, root.right);
        return flag;
    }
    private boolean DFS(TreeNode node1, TreeNode node2 ){
        if(!flag){
            return false;
        }
        if(node1==null && node2==null){
            return true;
        }
        if((node1==null && node2 !=null) || (node2==null && node1!=null)){
            flag = false;
            return false;
        }
        if(node1.val != node2.val){
            flag = false;
            return false;
        }
        DFS(node1.left,node2.right);
        DFS(node1.right,node2.left);
        return true;
    }
}
