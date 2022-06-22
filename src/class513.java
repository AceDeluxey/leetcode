/**
 * 513. 找树左下角的值
 * 在dfs时比高度就可以了，中序遍历 天然决定 第一次到新的高度的时候找到的就是最左边的节点
 * 0ms 100%
 */
public class class513 {
    int maxHeight = 0;
    int val = 0;

    public int findBottomLeftValue(TreeNode root) {
        DFS(root, 1);
        return val;
    }

    private void DFS(TreeNode node, int height) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            if (height > maxHeight) {
                val = node.val;
                maxHeight = height;
            }
            return ;
        }
        DFS(node.left, height + 1);
        DFS(node.right, height + 1);
    }
}
