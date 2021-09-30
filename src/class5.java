/**
 5. 最长回文子串

 思路：我用的是从两边向内扩散，用了递归。但是我在进入递归前判断量是否遍历过了，不知道为什么还是超时
        我看答案用的是中心向两边扩散，我觉得是一样的，只不过方向不一样而已

    超时
 */
public class class5 {
    boolean dp[][][];

    public String longestPalindrome(String s) {
        if (s.length() == 0) {
            return s;
        }
        String result = "" + s.charAt(0);

        //第三维用于标定dp[i][j]是否求过
        dp = new boolean[s.length()][s.length()][2];


        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                //如果dp[i][j]没有, 递归求
                if (!dp[i][j][0]) {
                    recur(i, j, s);
                }


                if (dp[i][j][1]) {
                    //如果当前dp的这一段字符串长度大于result替换
                    if (j - i + 1 > result.length()) {
                        result = s.substring(i, j+1);
                    }
                }
            }
        }
        return result;
    }

    private void recur(int i, int j, String s) {
        if (j == 0 || i == j) {
            dp[i][j][1] = true;
        } else {
            //两个字符也是特殊的，因为减了之后没有情况
            if (j == i + 1) {
                if (s.charAt(j) == s.charAt(i)) {
                    dp[i][j][1] = true;
                }

            } else {
                if (dp[i + 1][j - 1][0]) {
                    dp[i][j][1] = dp[i + 1][j - 1][1] && s.charAt(j) == s.charAt(i);
                } else {
                    recur(i + 1, j - 1, s);
                    dp[i][j][1] = dp[i + 1][j - 1][1] && s.charAt(j) == s.charAt(i);
                }
            }
        }


        //最后将标志位置位，代表遍历过
        dp[i][j][0] = true;
    }
}
