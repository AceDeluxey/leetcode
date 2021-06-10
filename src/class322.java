/**
 *  322. 零钱兑换
 *  给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 *  思路：最经典的dp,但是不同点在于coin的长度是不固定的，所以要用两个循环
 *       时间复杂度O(m*n)
 *
 *    18ms;42%
 */
public class class322 {
    public int coinChange(int[] coins, int amount) {
        if(amount==0){
            return 0;
        }
        int len = coins.length;
        int [] dp = new int[amount+1];
        //反正要循环初始化，可以先比较等于情况
        for( int i=0;i<len;i++){
            if(coins[i] < amount){
                dp[coins[i]]=1;
            } else if(coins[i] == amount){
                return 1;
            }
        }
        for ( int i=0;i<=amount ;i++){
            int min=Integer.MAX_VALUE;
            for( int j=0;j<len;j++){
                //钱币币值对应的已经初始化了
                if(dp[i]!=0){
                    break;
                }
                //dp[i-coins[j]]!=0说明凑不出来
                if(i-coins[j]>=0 && dp[i-coins[j]]!=0  ){
                    min=Math.min(min,1+dp[i-coins[j]]);
                }
            }
            if (min != Integer.MAX_VALUE ){
                dp[i]=min;
            }
        }
        return dp[amount]==0?-1:dp[amount];
    }
}
