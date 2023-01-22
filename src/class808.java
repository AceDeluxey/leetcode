/**
 * 808. 分汤
 * 还是很巧妙的一道题
 * 首先是一道概率题，然后是用dp做的，而且有一点是太大了以后概率收敛趋近于1，这个分析还是很神奇的
 * 3ms 74%
 */
public class class808 {
    public double soupServings(int n) {
        int N;
        if (n % 25 != 0) {
            N = n / 25 + 1;
        } else {
            N = n /25;
        }
        //玄学之处来了
        if(N>=179){
            return 1.0;
        }
        double dp [][] = new double [N+1][N+1];
        dp[0][0] = 0.5;
        for(int i =1;i<=N;i++){
            dp[0][i] =1.0;
        }
        for (int i=1;i<=n;i++){
            for (int j =1;j<=n;j++){
                //边界条件判断可以学习一下
                dp[i][j] = (dp[Math.max(0, i - 4)][j] + dp[Math.max(0, i - 3)][Math.max(0, j - 1)] + dp[Math.max(0, i - 2)][Math.max(0, j - 2)] + dp[Math.max(0, i - 1)][Math.max(0, j - 3)]) / 4.0;


            }
        }
        return dp[N][N];
    }
}
