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
 * 100. 相同的树
 * 一起遍历就行了
 * 0ms 100%
 */
public class class100 {
    boolean res  = true;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        DFS(p,q);
        return res;
    }
    private void  DFS( TreeNode p,TreeNode q){
        if(!res) return;
        if(p==null && q==null){
            return ;
        }
        if((p==null && q!=null) ||(q==null && p!=null) || p.val != q.val){
            res = false;
            return ;
        }
        DFS( p.left,q.left);
        DFS( p.right,q.right);
    }
}

