/*
    1872. 石子游戏 VIII
    思路：反向dp，有点神奇。
        dp[i]表示先手者可以选择[i,len-1）中的任意点开始往左拿后的最大值。
        那么对于第i堆石头，如果我们恰好从i开始拿，那么最大差值是我们拿了以后，对手也拿最优解，然后相减，就是sum[i]-dp[i+1]
        如果我们不拿第i堆，那么就是说会从i以后开始拿，不是从i开始，也就是说d[i]==d[i+1]
        我们取两者的最大值

    结果:5ms  82%
 */
public class class1872 {
    public int stoneGameVIII(int[] stones) {
        int len = stones.length;
        //dp[i]表示先手者可以选择[i,len-1）中的任意点开始往左拿后的最大值
        int dp[] = new int[len];
        int sum[] = new int[len];
        if(len == 1 ){
            return 0;
        }
        for(int i=0;i<len;i++){
            if(i==0){
                sum[i]=stones[i];
            } else {
                sum[i]=sum[i-1]+stones[i];
            }
        }
        dp[len-1]=sum[len-1];
        for(int i=len-2;i>=0;i--){
            dp[i]=Math.max(dp[i+1],sum[i]-dp[i+1]);
        }
        return dp[1];
    }
}
