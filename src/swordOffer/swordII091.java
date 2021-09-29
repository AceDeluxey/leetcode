package swordOffer;

/**
 * 剑指 Offer II 091. 粉刷房子
    假如有一排房子，共 n 个，每个房子可以被粉刷成红色、蓝色或者绿色这三种颜色中的一种，
    你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。

    思路：dp，虽然是三维，但实际上是一维的
        On 3ms  13%
 */
public class swordII091 {
    public int minCost(int[][] costs) {
        int dp[][] = new int[costs.length][3];
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];

        for (int i = 1; i < costs.length; i++) {
            dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i-1][0],dp[i-1][1]) + costs[i][2];
        }
        return Math.min(Math.min(dp[costs.length-1][0], dp[costs.length-1][1]),dp[costs.length-1][2]) ;
    }
}
