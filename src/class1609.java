import java.util.LinkedList;
import java.util.Queue;

/**
 *1609. 奇偶树
 * BFS就行
 * 8 ms 98.7%
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
class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        //当前层数
        int layer = 0 ;
        //当前层的节点数
        int num  = 1;
        boolean isMatch = true;
        while(queue.size() > 0){
            int temp_num=0;
            if( layer %2 ==0 ){
                //偶数层

                int last =  -1;
                for(int i  = 0 ;  i<num; i++){
                    TreeNode temp = queue.poll();
                    if(temp.val%2==0 || temp.val<=last){
                        isMatch = false;
                    } else{
                        last = temp.val;
                        if(temp.left !=null){
                            queue.offer(temp.left);
                            temp_num++;
                        }
                        if(temp.right !=null){
                            queue.offer(temp.right);
                            temp_num++;
                        }
                    }
                }
            } else{
                //奇数层
                int last =  Integer.MAX_VALUE;
                for(int i  = 0 ;  i<num; i++){
                    TreeNode temp = queue.poll();
                    if(temp.val%2!=0 || temp.val>=last){
                        isMatch = false;
                    } else{
                        last = temp.val;
                        if(temp.left !=null){
                            queue.offer(temp.left);
                            temp_num++;
                        }
                        if(temp.right !=null){
                            queue.offer(temp.right);
                            temp_num++;
                        }
                    }
                }
            }

            if(!isMatch){
                return false;
            }
            num = temp_num;
            layer++;
        }
        return true;

    }
}