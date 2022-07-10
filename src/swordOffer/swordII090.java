package swordOffer;

/**
 * 剑指 Offer II 090. 环形房屋偷盗
 * 其实就是把圈分成两个dp 一个dp是取了第一个数 那么最后只看dp[len-2]因为最后一个数肯定不能取
 * 另一种就是不取第一个 看dp[len-1]也就是最后一个dp
 * 0ms 100%
 */
public class swordII090 {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        //0代表不偷1, 1代表偷1
        int dp[][]  =  new int [nums.length][2];
        dp[0][1] = nums[0];
        dp[0][0] = 0;
        for(int i = 1; i < nums.length; i++){
            dp[i][1] = Math.max(dp[i-1][1],(i-2<0?0:dp[i-2][1])+nums[i]);
            dp[i][0] = Math.max(dp[i-1][0],(i-2<0?0:dp[i-2][0])+nums[i]);
        }
        return Math.max(dp[nums.length - 1][0],dp[nums.length - 2][1]);
    }
}
