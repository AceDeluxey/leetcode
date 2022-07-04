package swordOffer;

/**
 * 剑指 Offer II 096. 字符串交织
 * 实际上是很精妙的一道dp题目
 * 最开始一般都以为是双指针 但是单纯的用双指针 其实程序不知道选哪个可能得到最优解，所以用指针就要记忆化回溯等
 * 这里的dp中 i>0的情况代表在同一个位置取s1中的 j>0的情况代表取s2中字符的情况，相当于遍历了双指针中取两个指针的情况 所以能够work
 */
public class swordII096 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length(),len2 = s2.length(),len3=s3.length();
        if(len1 + len2 != len3){
            return false;
        }
        boolean [][]dp= new boolean[len1+1][len2+1];

        dp[0][0] = true;
        for(int i = 0; i <= len1; i++){
            for (int j = 0; j <= len2; j++) {
                int index = i+j-1;
                if(i>0){
                    dp[i][j] = dp[i][j] || (dp[i-1][j]&& s1.charAt(i-1)==s3.charAt(index));
                }
                if(j>0){
                    dp[i][j] = dp[i][j] || (dp[i][j-1]&& s2.charAt(j-1)==s3.charAt(index));
                }
            }
        }
        return dp[len1][len2];
    }
}
