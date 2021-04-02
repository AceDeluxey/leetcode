/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * 剑指 Offer 55 - II. 平衡二叉树
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
 * 如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 *
 * 思路：基于递归的DFS，思路在于计算每个节点的左子树和右子树的长度进行比较
 * 首先先到左侧树的最坐下节点，再到右节点，再到两个节点的父节点
 * 如果一个节点的子树是平衡的，返回左右最大长度+1作为该节点开始的树的长度
 * 如果有子树差>=2,则一直返回-1
 */
package swordOffer;
import DataStructure.TreeNode;
public class sword55 {
    public boolean isBalanced(TreeNode root) {
        return DFS(root)==-1? false:true;
    }
    private int DFS(TreeNode root){
        if (root == null) {
            return 0;
        }
        int left_height=DFS(root.left);
        if(left_height==-1){
            return -1;
        }
        int right_height=DFS(root.right);
        if(right_height==-1){
            return -1;
        }
        return Math.abs(left_height-right_height)<2? Math.max(left_height,right_height)+1:-1;
    }
}
