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

/**
 * 450. 删除二叉搜索树中的节点
 * 学到了怎么用初始函数进行递归，以前都是单独写一个dfs,其实只要返回本身，然后再上一级函数里赋值就行了
 * 然后是找到值了，删除以后怎么找新的root，可以在左树里找最右下角的，或者再右树里找左下角的，这样这个值就比左树都大，右树都小
 * 但是从树里取出一个值，就需要重新组织树。例如取左边的一个树中的node，就相当于从左树里删除node,就要递归查找delete左树中的node的val，然后这中间可能会递归重新delete其他值，把其他node提上来当子树的子树的root
 * 0ms 100%
 */
public class class450 {
    boolean flag;

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        }
        if (root.val == key) {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.left == null) {
                return root.right;
            }
            if(root.right == null){
                return root.left;
            }

            TreeNode node =  root.left;
            while(node.right!=null){
                node = node.right;
            }
            root.left =deleteNode(root.left,node.val);
            node.left = root.left;
            node.right = root.right;
            return node;
        }
        return root;
    }

}
