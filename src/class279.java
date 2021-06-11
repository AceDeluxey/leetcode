/**
 *      279. 完全平方数
 *      给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。

        思路：一开始完全没想到是dp
            想到就简单很多，dp[i]表示i的完全平方最小数，等于1+dp[i-j*j]中最小的一个，j是1到根号n

        时间复杂度是On根号n，35ms , 82%
 */

public class class279 {
    public int numSquares(int n) {
        int [] dp = new int [n+1];
        for( int i=1 ; i<=n ; i++){
            int min = Integer.MAX_VALUE;
            for(int j = (int) Math.floor(Math.sqrt((double)i));j>=1;j--){
                min = Math.min(min,1+dp[i-j*j]);
            }
            dp[i]=min;
        }
        return dp[n];
    }
}
