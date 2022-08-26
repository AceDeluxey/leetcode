import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * 1464. 数组中两元素的最大乘积
 * 就是找最大两个值
 */
public class class1464 {
    public int maxProduct(int[] nums) {
        Queue<Integer> que = new ArrayDeque<>();
        for(int i=0;i<nums.length;i++){
            if(que.size()==0){
                que.offer(i);
            } else  if(que.size()==1){
                if(nums[i]>=que.peek()){
                    que.offer(i);
                } else{
                    int temp = que.poll();
                    que.offer(i);
                    que.offer(temp);
                }
            } else{
                if (nums[i]>que.peek()){
                    que.poll();
                    que.offer(i);
                }
            }
        }
        return (nums[que.poll()]-1)*(nums[que.poll()]-1);
    }
}
