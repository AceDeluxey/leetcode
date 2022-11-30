/**
 * 813. 最大平均值和的分组
 *
 * 这种复杂一点逻辑的dp老是写的有问题 就是下标的逻辑有问题
 * debug太费时间了  不知道怎么能改善一下
 */
public class class813 {
    public double largestSumOfAverages(int[] nums, int k) {
        int len = nums.length;
        int sum[] = new int[len];
        double dp[][] = new double[len][k+1];

        for ( int i =1 ;i<len;i++){
            sum[i] = i-1>=0?sum[i-1]:nums[0];
        }
//        dp[0][1]=nums[0];
        for (int i =0 ;i<len;i++){
            for( int j=1;j<=Math.min(k,i);j++){
                if(j==0){
                    dp[i][1] = sum[i]/(i+1);
                }
                for( int m=1;m<=i;m++){
                    dp[i][j] = Math.max(dp[i][j],dp[m-1][j-1]+(sum[i]-sum[m-1])/(i - m + 1));
                }
            }
        }
        return dp[len-1][k];
    }
}
