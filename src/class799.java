/**
 * 799. 香槟塔
 * 一次性全部倒出来模拟，还是有点巧妙的
 * 上一层只会影响下一层的两个，所以顺序遍历就可以了
 *
 * ON2 2ms 98%
 */
public class class799 {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double dp[][] = new double [query_row+2][query_row+2];
        dp[0][0]=poured;
        for (int i=0;i<=query_row;i++){
            for (int j =0;j<=i;j++){
                if(dp[i][j]<=1){
                    continue;
                }
                dp[i+1][j] +=(dp[i][j]-1)/2;
                dp[i+1][j+1] +=(dp[i][j]-1)/2;
            }
        }
        return Math.min(dp[query_row][query_glass],1);
    }
}
