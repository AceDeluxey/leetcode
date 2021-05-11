
/*
    63. 不同路径 II
    一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
    机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
    现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？

    思路:与62很相似,就是只用把有石头的dp置为0就可以了
        0ms 99.29%
 */

public class class63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int [][]dp = new int [obstacleGrid.length][obstacleGrid[0].length];
        dp[0][0] = 1 ;
        for( int i=0; i< obstacleGrid.length; i++){
            for ( int j=0; j<obstacleGrid[0].length; j++){
                if(obstacleGrid[i][j]==1){
                    dp[i][j]=0;
                } else{
                    if(i-1>=0){
                        dp[i][j] += dp[i-1][j];
                    }
                    if(j-1>=0){
                        dp[i][j] += dp[i][j-1];
                    }
                }
            }
        }
        return dp[obstacleGrid.length-1][obstacleGrid[0].length - 1];
    }
}
