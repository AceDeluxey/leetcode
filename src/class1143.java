/**
 * 1143. 最长公共子序列
 * <p>
 * 思路：dp[i][j]等于text1[0:i]和text2[0:j]的最长公共子序列,就是长度为i和j的串
    这题适合多次做

    12ms 34%
 */
public class class1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        //i和j等于0时，dp也是0
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] +1;
                } else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[text1.length() ][text2.length()];
    }
}
