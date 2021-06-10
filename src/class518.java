
/**
 *  518. 零钱兑换 II
 *  给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
 *
 *  思路：dp,循环的方式很重要，
 *          代码1中的循环是每一个amount，都会用所有币去试一次，这样假设amount是5，coin是[1,2,3,4,5]，那么1和4，2和3就会重复计算
 *       而代码2中的循环是每次循环增加1个币去尝试，比如amount是3，coin是[1,2],先用1去凑3，有一种，再加入2，这时候只会算dp[3] += dp[3-2];而不会去算dp[3] += dp[3-1]，这样就避免了重复计算
        看答案说，还是01问题，我没发现，还要再看
    3ms 78%
 */
public class class518 {
    public int change(int amount, int[] coins) {
        int [] dp = new int [amount+1];
        dp[0]=1;
        /**
         * 代码1：
         */
//        for(int i=0;i<=amount;i++){
//            int sum = 0;
//            for( int j=0;j<coins.length; j++){
//                if (i-coins[j]>0){
//                    sum +=dp[i-coins[j]];
//                } else if(i-coins[j]==0){
//                    sum+=1;
//                }
//            }
//            dp[i] = sum;
//        }

        /**
         *  代码2:
         */
        for( int i=0;i<coins.length; i++){
            for ( int j=coins[i];j<=amount;j++){
                dp[j] += dp[j-coins[i]];
            }
        }
        return dp[amount];
    }
}
