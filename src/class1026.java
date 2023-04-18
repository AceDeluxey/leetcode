/**
 * 1026. 节点与其祖先之间的最大差值
 * 我觉得最根本的点就是在于
 * diff = Math.max(diff,DFS(node.left,min,max));
 *         diff = Math.max(diff,DFS(node.right,min,max));
 * 返回的值是当前点 和 左右点返回值的最大值，这样就能求出三个方向的值
 * 0ms 100%
 */
public class class1026 {
    public int maxAncestorDiff(TreeNode root) {

        return DFS(root,root.val,root.val);
    }
    public int DFS(TreeNode node , int min, int max ){
        if( node ==null){
            return 0;
        }
        int diff = Math.max(Math.abs(node.val)-min,Math.abs(node.val-max));
        min =  Math.min(min,node.val);
        max = Math.max(max,node.val);
        diff = Math.max(diff,DFS(node.left,min,max));
        diff = Math.max(diff,DFS(node.right,min,max));
        return diff;
    }
}
