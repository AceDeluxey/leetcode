import java.util.Arrays;
/*  354. 俄罗斯套娃信封问题
*
给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。

当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。

请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）

    思路：将信封从小到大排序后，可以降低复杂度
         因为排序后，对于每个信封，只要判断该处之前的信封与现在信封的大小
         就可以求出这个信封最多装的个数
* */

public class class354 {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes.length == 0){
            return 0;
        }
        for(int i=0;i<envelopes.length-1; i++){  //二维数组按一维排序，一维相同按第二维
            for(int j=0;j<envelopes.length-1-i;j++){
                if(envelopes[j][0]>envelopes[j+1][0]){
                    int temp[]=envelopes[j];
                    envelopes[j] = envelopes[j+1];
                    envelopes[j+1] = temp;
                } else if(envelopes[j][0]==envelopes[j+1][0]){
                    if(envelopes[j][1]>envelopes[j+1][1]){
                        int temp[]=envelopes[j];
                        envelopes[j] = envelopes[j+1];
                        envelopes[j+1] = temp;
                    }
                }
            }
        }
        int []dp=new int[envelopes.length];  //简单dp
        Arrays.fill(dp, 1);
        int result=1;
        for(int i=1;i<envelopes.length; i++){
            for(int j=0;j<i;j++){
                if(envelopes[i][0]>envelopes[j][0]  &&  envelopes[i][1]>envelopes[j][1]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            if(dp[i]>result){
                result=dp[i];
            }
        }
        return result;
    }
}
//class354 test=new class354();
//        int [][]a= {{5,4},{6,4},{6,7},{2,3}};
//
//        System.out.println(test.maxEnvelopes(a));