/**
 *  1510. 石子游戏 IV
 *       Alice 和 Bob 两个人轮流玩一个游戏，Alice 先手。
 *      一开始，有 n个石子堆在一起。每个人轮流操作，正在操作的玩家可以从石子堆里拿走 任意非零 平方数个石子。
 *      如果石子堆里没有石子了，则无法操作的玩家输掉游戏。
 *
 *  思路：太简单了，在石子游戏里。不懂为什么是困难，就是dp
 *
 *      17ms 62% , 时间复杂度是On2

 */

public class class1510 {
    public boolean winnerSquareGame(int n) {
        boolean [] dp= new boolean [n+1];
        for(int i=1 ; i<=n ;i++){
            int temp = (int)Math.sqrt(i);
            if(temp*temp == i){
                dp[i] = true;
            } else{
                for (int j = 1; j*j <= i; j++) {
                    if(dp[i-j*j]==false){
                        dp[i]=true;
                        break;
                    }
                }
            }
        }
        return dp[n];
    }
}
