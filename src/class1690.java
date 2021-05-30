
/*
    1690. 石子游戏 VII
    石子游戏中，爱丽丝和鲍勃轮流进行自己的回合，爱丽丝先开始 。
    有 n 块石子排成一排。每个玩家的回合中，可以从行中 移除 最左边的石头或最右边的石头，并获得与该行中剩余石头值之 和 相等的得分。当没有石头可移除时，得分较高者获胜。
    鲍勃发现他总是输掉游戏（可怜的鲍勃，他总是输），所以他决定尽力 减小得分的差值 。爱丽丝的目标是最大限度地 扩大得分的差值 。
    给你一个整数数组stones ，其中 stones[i] 表示 从左边开始 的第 i 个石头的值，如果爱丽丝和鲍勃都 发挥出最佳水平 ，请返回他们 得分的差值 。

    思路：DP
        dp[i][j]代表stones数组中，当只剩下i到j的石头堆时，先手者能够获得的数值与对手下一手获得的数值的最大差值
        那么转移方程，当i=j，最大差值为0
            当j=i+1，最大差值为两个数中大的那个值
            其他情况下，最大差值等于两种情况，一种是拿i,然后减去对手的dp[i+1][j]，另一种是j，然后减去dp[i][j-1]，取两者的最大值就是最大差值
        难点不在于转移方程，是遍历的方法。不是从i=0,j=0开始遍历，而是倒过来从i=len-1遍历。因为如果i=0,j=0第一次遍历，就算出dp[0][len-1]，这显然没有考虑到更多请看
            还有一个点就是i到j的sum其实可以在遍历中求出来

    结果：一次过 35ms 94.37%
 */
public class class1690 {
    public int stoneGameVII(int[] stones) {
        int len=stones.length;
        int dp[][] = new int [stones.length][stones.length];

        for(int i=len-1;i>=0; i--){
            int sum=stones[i];
            for( int j=i+1; j<stones.length; j++){
                //i到j元素的和
                sum+=stones[j];
                if(j-i==1){
                    dp[i][j]=Math.max(stones[i],stones[j]);
                } else if(j!=i){
                    //选左边的最大差值和右边的最大差值中大的那个,因为对手也是最优解
                    dp[i][j]=Math.max(sum-stones[i]-dp[i+1][j],sum-stones[j]-dp[i][j-1]);
                }
            }
        }
        return dp[0][len-1];
    }
}
