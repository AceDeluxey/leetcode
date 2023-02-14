import java.util.Stack;

/**
 * 1124. 表现良好的最长时间段
 * 比较巧妙的单调栈 还是比较值得看的
 * 重点是在这个左端点怎么满足这个单调栈的条件判断
 * 想到这个左端点的单调栈比较困难
 * 17 ms 43% On
 */
public class class1124 {
    public int longestWPI(int[] hours) {
        int len = hours.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int preSum [] = new int [hours.length+1];
        for (int i = 1; i <= len; i++) {
            preSum[i] = hours[i-1]>8?preSum[i-1]+1:preSum[i-1]-1;
            if(preSum[i]<preSum[stack.peek()]){
                stack.push(i);
            }
        }
        int res =0;
        for( int i = len;i>=1;i--){
            while(!stack.isEmpty() && preSum[i]>preSum[stack.peek()]){
                res = Math.max(res,i-stack.pop());
            }
        }
        return res;
    }
}
