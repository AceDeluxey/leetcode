/**
 * 583. 两个字符串的删除操作
 * <p>
 * 思路：和两字符串最长公共子序列是一样的，dp[i][j]代表word1中前i个字符，和word2前j个字符的最长公共子序列
 *
    Omn  8ms 59%
 */

public class class583 {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        //要去除的就是两个串的长度和，减去两倍的最长公共子序列
        return word1.length()+word2.length()-2*dp[word1.length()][word2.length()];
    }
}
