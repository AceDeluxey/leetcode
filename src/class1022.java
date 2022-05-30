/**
 * 1022. 从根到叶的二进制数之和
 * 10ms 6%
 * 学到了Integer.parseInt(s, 2); 转二进制字符串为int
 */
public class class1022 {
    int sum = 0;

    public int sumRootToLeaf(TreeNode root) {
        DFS(root, "");
        return sum;
    }

    private void DFS(TreeNode node, String s) {
        if (node.left == null && node.right == null) {
            s=s+Integer.toString(node.val);
//            System.out.println(s);
            //二进制字符串转int
            int temp = Integer.parseInt(s, 2);
            sum += temp;
        }
        if (node.right != null) {
            DFS(node.right,s+node.val);
        }
        if (node.left != null) {
            DFS(node.left,s+node.val);
        }
    }
}
