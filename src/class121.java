/**
 * 121. 买卖股票的最佳时机
 *  思路：Offer 63中使用动规通不过
 *  然后被答案误解了，其实不用使用单调栈
 *  实际上循环遍历股价，我们都可以假设当天股价是最高的，然后就转化成计算这一天股价与之前最低股价的差值
 *  而在循环中就可以求出i天前的最低股价
 *  这样ON时间复杂度就可以算出
 *  90% 32%
 */
import  java.util.Arrays;
public class class121 {
    public int maxProfit(int[] prices) {
        int min=0,result=0;
        if(prices.length != 0){
            min=prices[0];
        }
        for(int i=0;i<prices.length; i++){
            if(prices[i]-min>result){
                result=prices[i]-min;
            }
            if(prices[i] <min){
                min=prices[i];
            }
        }
        return result;

        //单调栈：没什么必要
//        int len= prices.length;
//        int []stack=new int [len];
//        int base=0,top=0;
//        int result=0;
//        for(int i=0;i<len;i++){
//            if(i==0){
//                stack[top++]=prices[i];
//                continue;
//            }
//            if(prices[i] >stack[top-1]){
//                if(result<prices[i]-stack[base]){
//                    result=prices[i]-stack[base];
//                }
//                stack[top++]=prices[i];
//            }else if(prices[i] < stack[top-1]){
//                top--;
//                stack[top++]=prices[i];
//            }
//        }
//        return result;
    }
}
