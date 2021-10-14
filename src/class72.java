/**
    72. 编辑距离
    思路：先想的是dp是三维代表三个操作，
        dp[i][j]应该是word1里长度为i的串到word2里长度为j的串的操作步骤
        注释看代码
    5ms 88%

 */
public class class72 {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
//        int[] dp = new int[word2.length()];

        //从word1里到word2长度为0， 要一直删除
        for( int i =1;i<=word1.length(); i++){
            dp[i][0]=dp[i-1][0] +1;
        }

        //word1长度为0到word2 要一直增加
        for( int i =1;i<=word2.length(); i++){
            dp[0][i]=dp[0][i-1] +1;
        }

        for( int i =1 ; i<= word1.length(); i++){
            for (int j = 1; j <= word2.length(); j++) {

                //一样不操作
                if( word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                } else{
                    //不一样时，因为dp[i][j]之前经过操作都相同了，所以i和j不同只用在三个操作中选择一个做就可以了。
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]),dp[i][j-1])+1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
