package swordOffer;
/**
 * 剑指 Offer 55 - I. 二叉树的深度
 * 输入一棵二叉树的根节点，求该树的深度。
 * 从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，
 * 最长路径的长度为树的深度。
 *
 * 就是普通的递归，100% 61.07%
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import DataStructure.TreeNode;
public class sword55Ⅰ {
    public int maxDepth(TreeNode root) {
        return DFS(root);
    }
    public int DFS(TreeNode root){
        if(root==null){
            return 0;
        }
        int left_height=DFS(root.left);
        int right_height=DFS(root.right);
        return Math.max(left_height,right_height)+1;
    }
}
