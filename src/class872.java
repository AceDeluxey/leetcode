
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
        872. 叶子相似的树
        请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
        就是看两棵树的叶子节点值和顺序是否一致

        思路：遍历是很容易想到的比如DFS，最简单的方法是分别遍历两棵树，记录下叶子节点再比较
            但是其实可以第二次不用遍历完就知道是否相同。
            那就写两个dfs，第一个是遍历第一个记下叶子节点
            DFS2是遍历第二个，遍历的途中就比较是否与root1的叶子节点List相同，
            如果不同，就将全局变量ifBreak置为true，剩下的递归就可以很快速的返回出去

           0ms 100%

 */
import DataStructure.TreeNode;

import java.util.ArrayList;

public class class872 {
    ArrayList<Integer> list = new ArrayList<>();
    boolean ifBreak =false;
    int index=0;
    int numsOfLeafinTree2 =0;
    boolean ifSimilar =true;
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        DFS1( root1 );
        DFS2( root2 );
        //特殊情况是第二棵树的叶子少，但是值相同
        return numsOfLeafinTree2== list.size()? ifSimilar:false;
    }
    public void DFS1(TreeNode node1 ){
        if(node1 == null){
            return;
        }
        if(node1.left == null && node1.right==null){
            list.add(node1.val);
            return ;
        }

        DFS1(node1.left);
        DFS1(node1.right);
    }
    public void DFS2(TreeNode node2 ){
        if(node2== null){
            return;
        }
        if(node2.left == null && node2.right==null){
            numsOfLeafinTree2++;
            //确保叶子数小于等于list ; 第二次遍历不用遍历完，有不同就直接ifBreak =true;
            if(numsOfLeafinTree2>list.size() || node2.val != list.get(index++)){
                ifBreak =true;
                ifSimilar=false;
            }
            return ;
        }

        if(ifBreak){  //说明此时已经不同了，没有必要继续递归
            return ;
        }
        DFS2(node2.left);
        DFS2(node2.right);
    }
    /*
        Integer [] a={1,2,3};
        TreeNode root1 =new TreeNode(a);
        Integer [] b={1,3,2};
        TreeNode root2 =new TreeNode(b);
        class872 test1 = new class872();
        System.out.println(test1.leafSimilar(root1,root2));
     */
}
