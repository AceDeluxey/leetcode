import jdk.internal.org.objectweb.asm.tree.IincInsnNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 508. 出现次数最多的子树元素和
 * 3ms 97%
 * dfs 和 map很简单
 */

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
public class class508 {
    int max = 0;
    Map<Integer,Integer> map;
    public int[] findFrequentTreeSum(TreeNode root) {
        map = new HashMap<>();
        DFS(root);
        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if (entry.getValue()==max) {
                list.add(entry.getKey());
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            ans[i] = list.get(i);
        }
        return ans;


    }
    private int  DFS(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = DFS(node.left);
        int right = DFS(node.right);
        int sum = left +right +node.val;
        int num = map.getOrDefault(sum,0)+1;
        max = Math.max(max,num);
        map.put(sum,num);
        return sum;
    }
}
