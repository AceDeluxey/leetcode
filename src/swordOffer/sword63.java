package swordOffer;

/**
 * 剑指 Offer 63. 股票的最大利润
 * 虽说是用动规，但是dp数组都可以省略
 * 实际上是简化的动规，但是相当于on2,不太行 5% 35%
 */
public class sword63 {
    public int maxProfit(int[] prices) {
        int len= prices.length;


        int result=0;
        for(int i=1;i<len;i++){
            for(int j=0;j<i;j++){
                if(prices[i]>prices[j]){
                    if(result<prices[i]-prices[j]){
                        result = prices[i]-prices[j];
                    }
                }
            }
        }
        return result;
    }
}
