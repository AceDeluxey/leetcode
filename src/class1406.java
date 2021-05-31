/*
    1406. 石子游戏 III

    思路：还是dp
        第一次优化想法：对内存限制有要求，观察了一下发现其实不需要整个dp矩阵，只需要dp[i+1][len-1]，dp[i+2][len-1]，dp[i+3][len-1]三个变量就可以
            所以我们化简
        第二次优化方法：在化简时，发现只需要一个int [] dp = new int [stoneValue.length];而且只需要一次遍历
        ｄｐ［ｉ］代表一个玩家从ｉ处开始拿的最大值
        然后倒过来ｄｐ遍历就可以了，当只有１个只能拿，当有２个择优拿，当有３个比较拿一个、２个、３个
           值得注意的时，我们选的最优解是后ｉ个的ｓｕｍ－ｄｐ［ｉ＋１］，因为对手也是最优解

        ６ｍｓ　９１．３％；４７．８Ｍ　７６．６３％
 */
public class class1406 {
    public String stoneGameIII(int[] stoneValue) {
        int len = stoneValue.length;
        int [] dp = new int [stoneValue.length];
        int sum =0;
        for( int i=len-1;i>=0;i--){
            sum+=stoneValue[i];

                //因为有负的，所以要考虑三种情况
                if(len-i==1){
                    int temp=0;
                    for( int k=i;k<len;k++){
                        temp+=stoneValue[k];
                    }
                    dp[i]=temp;
                } else if( len -i ==2){
                    dp[i]=Math.max(stoneValue[i],stoneValue[i]+stoneValue[i+1]);
                } else if( len -i ==3){
                    dp[i]=Math.max(sum-dp[i+1],sum-dp[i+2]);
                    dp[i]=Math.max(dp[i],sum);
                } else {
                    dp[i]=Math.max(sum-dp[i+1],sum-dp[i+2]);
                    dp[i]=Math.max(dp[i],sum-dp[i+3]);
                }

        }
        if(dp[0]==sum-dp[0]){
            return "Tie";
        } else if (dp[0]>sum-dp[0]){
            return   "Alice";
        } else {
            return "Bob";
        }
        // dp矩阵，超内存限制
//        int len = stoneValue.length;
//        int [][] dp = new int [stoneValue.length][stoneValue.length];
//        int sum =0;
//        for( int i=len-1;i>=0;i--){
//            sum+=stoneValue[i];
//            for( int j=i;j<len;j++){
//                //因为有负的，所以要考虑三种情况
//                if(len-i==1){
//                    int temp=0;
//                    for( int k=i;k<len;k++){
//                        temp+=stoneValue[k];
//                    }
//                    dp[i][j]=temp;
//                } else if( len -i ==2){
//                    dp[i][j]=Math.max(stoneValue[i],stoneValue[i]+stoneValue[i+1]);
//                } else if( len -i ==3){
//                    dp[i][j]=Math.max(sum-dp[i+1][len-1],sum-dp[i+2][len-1]);
//                    dp[i][j]=Math.max(dp[i][j],sum);
//                } else {
//                    dp[i][j]=Math.max(sum-dp[i+1][len-1],sum-dp[i+2][len-1]);
//                    dp[i][j]=Math.max(dp[i][j],sum-dp[i+3][len-1]);
//                }
//            }
//        }
//        if(dp[0][len-1]==sum-dp[0][len-1]){
//            return "Tie";
//        } else if (dp[0][len-1]>sum-dp[0][len-1]){
//            return   "Alice";
//        } else {
//            return "Bob";
//        }
    }
}
