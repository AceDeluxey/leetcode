/**
 * 01背包问题
 * dp[i][j]等于只用0到i个物品装到重量j的时候，最多装的价值。
 * 还是比较符合逻辑的，但还是有点抽象
 * 要多写几次
 */
public class CLASS01 {
    public static void main(String[] args) {
        int[] wright = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagWeight = 4;
        CLASS01 test = new CLASS01();
        test.calculate(value, wright, bagWeight);
    }

    int calculate(int value[], int[] weight, int bagWeight) {
        int len = value.length;
        int[][] dp = new int[len][bagWeight + 1];
        for (int i = 0; i < len; i++) {
            dp[i][0] = 0;
        }
        for (int i = weight[0]; i <= bagWeight; i++) {
            dp[0][i] = value[0];
        }
        for (int i = 1; i < len; i++) {
            for (int j = 1; j <= bagWeight; j++) {
                //这样无论如何装不下这一个，所以dp等于dp[i-1][j]
                if(j<weight[i]){
                    dp[i][j] = dp[i-1][j];
                } else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weight[i]]+value[i]);
                            // 第一个是不取i所以是dp[i-1][j]  第二个是选取，那么需要减去容量
                            //所以这里j是有j的容量可以用
                }

            }
        }
        return dp[len-1][bagWeight];
    }
}
