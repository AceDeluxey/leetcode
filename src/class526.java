/**
 * 526. 优美的排列
     * 思路：很牛批的状态压缩，看解析了
     * dp[i][state]代表现在n以内,状态为state时的总数
 *
 *     71ms 61%
 */
public class class526 {
    public int countArrangement(int n) {
        //总共有00..0到11.。1种状态，也就是1<<n，要加一
        int mask = 1 << n;
        int[][] dp = new int[n + 1][mask];
        //dp[0][0]有一种可能，其他例如dp[0][1]没有可能
        dp[0][0] = 1;
        //对每一个数字进行遍历
        for (int i = 1; i <= n; i++) {
            //每一个数字的每一种state
            for (int state = 0; state < mask; state++) {
                //k代表第i位选的数字，循环找到可能结果
                for (int k = 1; k <= n; k++) {
                    //k如果是满足条件的，首先要能够互相整除之一，然后state上k要是1
                    //state上k位要为1，则state右移k-1位与1要为1
                    //此时说明第i位可以是k
                    if((k%i==0 || i%k==0) && (state >> (k-1)&1)==1){
                        //第i位是k，可以增加dp
                        //意思是当第i位是k时，dp[i][state]的种类位n为i-1时，state状态去掉k位的1时，的种类数
                        //~(1<<(k-1))就是第K位是0,其他是1的数，与state与获得我们要的值
                        dp[i][state] = dp[i-1][state & (~(1<<(k-1)))];
                    }

                }

            }
        }
        //返回为n时，最终状态
        return dp[n][mask-1];
    }
}
