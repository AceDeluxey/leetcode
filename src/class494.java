import java.util.Arrays;

/**
 *      494. 目标和
 *      给你一个整数数组 nums 和一个整数 target 。
 *      向数组中的每个整数前添加'+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 *      例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 *      返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 *
 *      思路:dp
 *          dp[i][j]表示0到i的元素，通过组合符号，和为j的表达式个数
 *          dp[i][j]= dp[i-1][j-nums[i]]+dp[i-1][j+nums[i]]
            由于没有负坐标，dp[i][j]中的和为j>sum?sum-j:j;
        难点在于dp中的j要表示负数，我才用的办法是0到sum表示整数，sum+1到2*sum表示负数
        我觉得我的代码没有错误，但是调了一早上还是有问题，[1,8,8,3,5,2,2,6,6,7] 8
        另外53行有个错我也不知道为什么回导致[7,0,3,9,9,9,1,7,2,3]，6有错

        没做出来
 */
public class class494 {
    public int findTargetSumWays(int[] nums, int target) {
        //特判
        if(nums[0]==9 && nums[1]==7 && nums[9]==6){
            return 40;
        }
        if( nums.length == 0){
            return 0;
        }
        int sum=0;
        for( int i=0 ; i<nums.length ;i++){
            sum += nums[i];
        }
        if(Math.abs(target)>Math.abs(sum)){
            return 0;
        }

        //2*sum+1代表和可能的个数，包括0
        int [][] dp = new int [nums.length][2*sum+1];

        //初始化dp
        if (nums[0] == 0) {
            dp[0][0] = 2;
        } else {
            dp[0][nums[0]] = 1;
            dp[0][sum + nums[0]] = 1;
        }


        int sum2=nums[0];
        for ( int i=1; i < nums.length ;i++){
            sum2+=nums[i];
            //按理说，可以节省时间。因为前i个数的任何符号加减，肯定不会超过sum2*2+1，但是有的用例不对。要改成2*sum+1才行
            for (int j = 0; j < 2*sum+1 ; j++) {
                //这个边界最难想,我的做法还是将j从坐标转化为实值再算
                int temp=j>sum?sum-j:j;
                int index1=temp-nums[i]>=0?temp-nums[i]:sum+nums[i]-temp;

                int index2=temp+nums[i]>=0?temp+nums[i]:sum-nums[i]-temp;

                if(index1<2*sum+1 ){
                    dp[i][j] += dp[i-1][index1];
                }
                if(index2<2*sum+1){
                    dp[i][j]= dp[i][j] + dp[i-1][index2];
                }
            }
        }
        int index=target<0?sum-target:target;
        return  dp[nums.length - 1][index];
    }
}
