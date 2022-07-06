package swordOffer;

/**
 * 剑指 Offer II 089. 房屋偷盗
 * 典型的dp 不过我这次脑回路比较奇怪，把dp拆成两个来写了， 一个代表取当前屋子，一个代表不取
 * 如果写成一个可以  取dp[i-2]+当前 和 dp[i-1】中的最大，前一个代表上家没取，后一个代表上家取了
 *
 * 0ms 100%
 */
public class swordII089 {
    public int rob(int[] nums) {
        //0 代表不取这一家， 1 代表取这一家
        int dp[][] = new int [nums.length][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i][1]= dp[i-1][0]+nums[i];
            dp[i][0] = Math.max(dp[i-1][1],dp[i-1][0]);
        }
        return Math.max(dp[nums.length - 1][0],dp[nums.length - 1][1]);
    }
}
