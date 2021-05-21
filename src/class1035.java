
/*
    1035. 不相交的线
    在两条独立的水平线上按给定的顺序写下 nums1 和 nums2 中的整数。
    以这种方法绘制线条，并返回可以绘制的最大连线数。


    思路:dp[i][j]是nums1数组第i位和nums2j位前最大连线数
        转移方程还是比较简单
        dp里只有三个变量用得到，可以不用矩阵节省空间
      5ms 97%
 */
public class class1035 {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int [][] dp = new int [nums1.length+1][nums2.length+1];
        for(int i=1;i<=nums1.length;i++){
            for(int n=1;n<=nums2.length;n++){ //从1开始免除特判
                if(nums1[i-1]==nums2[n-1]){      //转移方程
                    dp[i][n]= dp[i-1][n-1] +1;
                } else{
                    dp[i][n]= Math.max(dp[i-1][n] ,dp[i][n-1]);
                }
            }
        }
        return dp[nums1.length][nums2.length];
    }
}
