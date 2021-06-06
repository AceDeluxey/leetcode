/**
 *
 *      474. 一和零
 *      给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 *      请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
        如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 *
 *      思路:dp,没想出来，看答案的，总感觉有点奇怪
 *          dp[i][j][k]表示在0到i的字符串种，取j个0，k个1的最大子集数量
 *
 *       87ms 18%
 */

public class class474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int [][][] dp = new int [len+1][m+1][n+1];
        for( int i =1 ; i<=len ; i++ ){
            //避免i-1的特判，所以dp后移一行
            int []temp = countZeroes(strs[i-1]);
            for( int j=0; j<=m ;j++){
                for( int k=0; k<=n ;k++){
                    //j和k不够减的情况，说明当前字符串不取
                    dp[i][j][k] = dp[i-1][j][k];
                    int zero=temp[0],one=temp[1];
                    if(zero<=j && one <= k){
                        dp[i][j][k]=Math.max(dp[i][j][k],dp[i-1][j-zero][k-one]+1);
                    }
                }
            }
        }
        return dp[len][m][n];
    }
    public int[] countZeroes (String s){
        int res [] = new int [2];
        for (int i=0;i<s.length(); i++){
            res[s.charAt(i)-'0']++;
        }
        return res;
    }
}
