/**
 * 122. 买卖股票的最佳时机 II
 *  思路： 贪心算法，因为可以多次买卖，所以我们可以避免所有下跌
 *  所以只需比较与前一天的股价，如果股价是上涨，那么我们就在前一天买，后一天卖
 *  这样就能保证上涨的股票我们必定全部买到，是最优解
 *
 *  99% 48%
 */

public class class122 {
    public int maxProfit(int[] prices) {
        int result=0;
        if(prices.length == 1){
            result=0;
        }else{
            for(int i=1;i<prices.length;i++){
                if(prices[i] -prices[i-1]> 0){
                    result += prices[i]-prices[i-1];
                }
            }
        }
        return result;
    }
}
