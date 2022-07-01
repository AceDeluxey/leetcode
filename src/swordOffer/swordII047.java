package swordOffer;

import DataStructure.TreeNode;

/**
 * 剑指 Offer II 047. 二叉树剪枝
 * 想复杂了， 还是dfs就行，从底层开始剪就行了
 *
 * 0ms 100%
 */
public class swordII047 {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        root.left=pruneTree(root.left);
        root.right=pruneTree(root.right);
        if(root.val ==0 && root.left ==null && root.right == null){
            root = null;
        }
        return root;
    }

}
