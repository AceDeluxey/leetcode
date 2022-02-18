/**
 * 688. 骑士在棋盘上的概率
 * 怎么拆分成子任务
 * 比如跳2步在棋盘的概率，可以分解为两步，先跳一次，可能到八个点，再每个点跳一次的概率乘八分之一加起来 就是结果
 * 但是我们没办法用跳的顺序算，因为最先跳的步数，要用到后跳的概率
 * 例如跳3步时，我们要先知道跳2步的概率，跳2步要先知道跳1步
 * 所以要先算从棋盘各个位置跳一步不出去的概率，再算2步，3步 这样才算的出来
 *
 * 参考了答案
 * 7ms 61%
 */
public class class688 {
    public double knightProbability(int n, int k, int row, int column) {
        //dp 数据代表从i j 位置的棋 还剩step步要跳后，仍在棋盘上的概率
        double [][][] dp = new double[k+1][n][n];
        //dp初始化,不跳在原地的概率必定是1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[0][i][j] = 1;
            }
        }
        int[][] dires = {{-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}};
        for (int step = 1; step <= k; step++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int[] dir : dires) {
                        int ni = i + dir[0], nj = j + dir[1];
                        if(ni<0 || ni>=n || nj<0 || nj>=n) continue;
                        //可能跳八个方向出去
                        dp[step][i][j]+= dp[step-1][ni][nj]*1/8;
                    }
                }
            }
        }
        return dp [k][row][column];
    }
}
