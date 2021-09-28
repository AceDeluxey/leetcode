import java.util.HashMap;
import java.util.Map;


/**
 437. 路径总和 III
    给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。

    思路：DFS+前缀和，这样就只用DFS一次；核心在于想到用前缀和减法，以及出节点时删除保证路径向下
    2ms 100%
 */
//  Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


public class class437 {
    int result =0;
    //<val, num>
    Map<Integer, Integer> map ;
    int target;
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return 0;
        }
        target = targetSum;
        map = new HashMap<>();
        //0的情况是要加进去的，因为要sum-target，0也是满足的路径
        map.put(0,1);
        DFS(root,root.val);
        return result;
    }
    private  void DFS(TreeNode node, int sum){
        if(map.containsKey(sum-target)){
            result += map.get(sum - target);
        }

        map.put(sum,map.getOrDefault(sum,0)+1);

        if(node.left != null){
            DFS(node.left,sum+ node.left.val);
        }

        if(node.right != null){
            DFS(node.right, sum+ node.right.val);
        }

        //从一个节点出来之前，要将从这个节点的前缀和减去；否则出来有可能从左节点到右节点，这样如果不减去，就不是向下路径了
        map.put(sum,map.getOrDefault(sum,0)-1);
    }
}
