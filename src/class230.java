/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/*
    230. 二叉搜索树中第K小的元素
    思路：二叉搜索树中序遍历就是从小到大排序
          所以只要中序遍历找到第k个就可以
          中序遍历一直找到最左节点，就是最小值，所以我们先找最小节点，再找第k小的点
    44ms 5.99%
 */
public class class230 {
    int k1;
    boolean flag=true;
    int res=0;
    public int kthSmallest(TreeNode root, int k) {
        k1=k;
        DFS(root);
        return res;
    }
    private void DFS(TreeNode node){
        System.out.println(k1);
        if(k1==0){
            return;
        }
        if(node.left != null){
            DFS(node.left);
        } else{

            flag=true;
        }

        if(flag){
            k1--;
            if(k1==0){
                res=node.val;
                return;
            }
        }

        if(node.right != null){
            DFS(node.right);
        }
    }
}
