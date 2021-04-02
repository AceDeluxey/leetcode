package Interview;

/**
 * 面试题34. 二叉树中和为某一值的路径
 *      输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
 *      从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 *
 *      思路：
 *      ① 很容易想到用递归去遍历树的每一条路，但是我最初想法是自底向上将val add到
 *      list中，当遍历到底如果满足target==val,就不断向上返回1，如果判断返回了1，就
 *      add。但是存在两个问题：一是list顺序是颠倒的，二是不知道怎么把这些list add进
 *      一个新的list中
 *      ② 参考了答案后，知道可以通过定义成员变量来解决上述第二个问题
 *         而自顶向下的方法就是，对每一个节点都add 到list中，但是最后只有最后一个叶子
 *         节点val=target，才把这个List add到result中。
 *         另一个值得注意的点是，在一个父节点中，同时对他的左右子节点调用了。答案最后对list
 *         进行了removeLast操作。我的理解是这个list的地址可能一样，先遍历左子树后，要遍历右
 *         子树，这样要先把左边的节点删除，才能遍历右边节点。
 *         另一个值得注意的是在遍历到叶子节点后，要将list加入result中，但是此时用
 *         result.add(list);  会有结果错误
 *         result.add(new LinkedList<Integer>(list)); 这样才对
 *         我猜测可能还是因为递归调用中所有list用同一个地址的原因。
 *
 *         100% 97%
 */

import DataStructure.TreeNode;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
public class interview34 {
    private List<List<Integer>> result= new LinkedList<List<Integer>>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        LinkedList<Integer> list=new LinkedList<Integer>();
        search(root,target, list);
        return result;
    }
    public boolean search(TreeNode root,int target,LinkedList list){
        if(root==null){
            return false;
        }
        list.add(root.val);
        if(root.val==target && root.left == null && root.right == null){

            result.add(new LinkedList<Integer>(list));
        }
        search(root.left,target-root.val,list);
        search(root.right,target - root.val,list);

        list.removeLast();
        return false;
    }
}
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