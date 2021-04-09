import DataStructure.TreeNode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/*
    337. 打家劫舍 III
    在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。

    计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。

    思路：想错了，想成只要计算出每层的和，构成一个数组。这个数组打一次就行了
        [2,1,3,null,4]这颗树可以看出错了
        但是写的BFS遍历树，求每层的和写的还行吧
 */
public class class337 {
    public int rob(TreeNode root) {
        LinkedList<Integer> nums = BFS(root);
        int dp1,dp2,dp3=0;
        if(nums.size() == 1){
            return nums.get(0);
        }
        if(nums.size() == 2){
            return Math.max(nums.get(0),nums.get(1));
        }
        dp1=nums.get(0);
        dp2=Math.max(nums.get(0),nums.get(1));
        for( int i=2;i < nums.size(); i++){
            dp3=Math.max(dp1+nums.get(i),dp2);
            dp1=dp2;
            dp2=dp3;
        }
        return dp3;
    }

    public LinkedList BFS(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        LinkedList<Integer> nums = new LinkedList<Integer>();

        queue.add(root);  //根入队列，Level为1
        int level=1;
        int cnt[]=new int [2];  //用cnt数组表示当前循环层的节点数，和下一层循环的节点数
        cnt[0] =1;
        int flag=0;   //flag代表用第几个cnt
        while(!queue.isEmpty()){     //队列不空
            int sum=0;
            for(int i=0;i< cnt[flag];i++){      //小于该层的节点数
                if(queue.peek() != null){
                    sum+=queue.peek().val;           //遍历到该节点后左右子节点入队列
                    if(queue.peek().left != null  ){
                        queue.add(queue.peek().left);
                        cnt[(flag+1)%2]++;  //flag=1时，(flag+1)%2=0； flag=0时，(flag+1)%2=1
                    }                       //这样保证在循环时，计算下一层的cnt
                    if(queue.peek().right != null){
                        queue.add(queue.peek().right);
                        cnt[(flag+1)%2]++;
                    }
                }
                if(!queue.isEmpty()){
                    queue.remove();   //出队列
                }

            }
            level++;
            cnt[flag]=0;         //循环完后置零
            flag=(flag+1)%2;       //flag变换
            nums.add(sum);       //层的和加入到
        }
        return nums;
    }
}
