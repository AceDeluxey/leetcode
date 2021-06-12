/**
 *      292. Nim 游戏
 *      你和你的朋友，两个人一起玩 Nim 游戏：
 *          桌子上有一堆石头。
 *          你们轮流进行自己的回合，你作为先手。
 *          每一回合，轮到的人拿掉 1 - 3 块石头。
 *          拿掉最后一块石头的人就是获胜者。
 *
 *      思路：石子游戏的简化版，主要就是1348820612会超内存
 *              不能用数组，用三个Int;
 *              结果简化数组，时间超了
 *              离谱，结果是用数学方法
 *           0ms 100%
 */

public class class292 {
    public boolean canWinNim(int n) {
        return (n % 4 != 0);

//        boolean [] dp = new boolean [4];
//        for (int i = 1; i <=3; i++) {
//            dp[i]=true;
//        }
//        for (int i = 4; i <= n; i++) {
//            if(i>3) {
//                //恰好用来当暂存
//                dp[0]=dp[3];
//                //拿完对手会输，自己就必赢；拿完对手全赢，自己就必输
//                dp[3]=!(dp[0] && dp[2] &&  dp[1]);
//                dp[2]=dp[0];
//                dp[1]=dp[2];
//            }
//        }
//        return dp[3];

//        boolean [] dp = new boolean [n+1];
//
//        for (int i = 0; i <= n; i++) {
//            if(i<=3){
//                dp[i]=true;
//            } else {
//                //拿完对手会输，自己就必赢；拿完对手全赢，自己就必输
//                dp[i]=!(dp[i-1] && dp[i-2] &&  dp[i-3]);
//            }
//        }
//        return dp[n];
    }
}
