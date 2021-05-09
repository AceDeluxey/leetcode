/*
    62. 不同路径
    一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
    机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。

    思路：一开始看到会想到用DFS啥的，后来才想起来使用动规
        起点到 i j格子的路径数量，等于到i-1 j格子数量+  i j-1格子数量

        0ms 100%；
 */

public class class62 {
    public int uniquePaths(int m, int n) {
        int dp[][]=new int [m][n];
        dp[0][0]=1;
        for( int i=0;i<m;i++){
            for(int j=0; j<n;j++){
                int temp=dp[i][j];
                if(i-1>=0){
                    temp+=dp[i-1][j];
                }
                if(j-1>=0){
                    temp+=dp[i][j-1];
                }
                dp[i][j]=temp;
            }
        }
        return dp[m-1][n-1];
    }
}
