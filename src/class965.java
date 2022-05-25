/**
 * 965. 单值二叉树
 * 简单 0 100
 */
public class class965 {
    boolean flag = true;
    public boolean isUnivalTree(TreeNode root) {
        DFS(root, root.val);
        return flag;
    }
    private  void DFS(TreeNode node, int last) {
        if(!flag || node==null){
            return ;
        }
        if(node.val != last){
            flag = false;
        }
        DFS(node.left, node.val);
        DFS(node.right, node.val);
    }
}
