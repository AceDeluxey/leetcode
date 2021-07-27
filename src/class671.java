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

import DataStructure.TreeNode;

/**
 * 671. 二叉树中第二小的节点
 *
 *  思路：简单，就用一个数组存储最小值和次小值，但是就是测试用例用了[2,2147483647]有点恶心
 *      要把MAX_VALUE改成long的
 *      还有一种方法就是左子树和右子数分别求最小值，这样就不会越界了
 *
 *      0ms 100%
 */
public class class671 {
    //第一位存储最小值，第二位存储次小值
    long [] min = new long[2];

    public int findSecondMinimumValue(TreeNode root) {
        //初始化
        min[0] = Long.MAX_VALUE;
        min[1] = Long.MAX_VALUE;

        DFS(root);
        return min[1] <= 2147483647 ? (int) min[1] : -1;

    }

    public void DFS(TreeNode node) {
        if (node != null) {
            DFS(node.left);
            DFS(node.right);
        } else {
            return;
        }

        //判断最小值和次小值，放进数组里
        if (node.val < min[0]) {
            min[1] = min[0];
            min[0] = node.val;
        } else if (node.val < min[1] && node.val != min[0]) {
            min[1] = node.val;
        }
    }
}
