import DataStructure.TreeNode;
/*/
    783. 二叉搜索树节点最小距离
    给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。

    思路：二叉搜索树中序遍历即是有序递增数组
          在递增数组中，相差最小的值一定在相邻两个元素中
           但是在树中，相邻的元素有可能不直接相连，体现在右节点与根节点不相连，所以要记录上一个遍历的值
           才能在遍历中直接找到最小值
           pre就是中序遍历中遍历的中间节点的VAL

       0ms 100%；

 */
public class class783 {
    int min=Integer.MAX_VALUE;
    int pre=-1;
    public int minDiffInBST(TreeNode root) {
        LDR(root);
        return min;
    }
    public void LDR(TreeNode node){
        if(node==null){
            return ;
        }
        LDR(node.left);
        if (pre != -1) {
            if (Math.abs(pre - node.val) < min) {
                min = Math.abs(pre - node.val);
            }
        }
        pre= node.val;
        LDR(node.right);
    }
}
