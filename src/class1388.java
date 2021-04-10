/**
 *      1388. 3n 块披萨
 *
         给你一个披萨，它由 3n 块不同大小的部分组成，现在你和你的朋友们需要按照如下规则来分披萨：

         你挑选 任意 一块披萨。
         Alice 将会挑选你所选择的披萨逆时针方向的下一块披萨。
         Bob 将会挑选你所选择的披萨顺时针方向的下一块披萨。
         重复上述过程直到没有披萨剩下。
         每一块披萨的大小按顺时针方向由循环数组 slices 表示。

         请你返回你可以获得的披萨大小总和的最大值。

        思路：和打家劫舍Ⅱ很像，但是不同在于这题取的个数上限是n个，所以dp中还要加一维限制取的个数
            也就是等价于在3n的数组中找到n个不相邻的数加和最大
            环形的处理方式与打家劫舍一样，就是拆分成有第一个和没有第一个的两条

 */

public class class1388 {
    public int maxSizeSlices(int[] slices) {
        int[] slices1 = new int[slices.length - 1];
        System.arraycopy(slices, 1, slices1, 0, slices.length - 1);
        int[] slices2 = new int[slices.length - 1];
        System.arraycopy(slices, 0, slices2, 0, slices.length - 1);


        return Math.max(dp(slices1),dp(slices2));


    }
    public int dp(int[] slices){
        int len = slices.length;
        int dp[][]=new int[len][(len+1)/3+1];  //饼可以取0块，所以要+1
        dp[0][0]=0;                 //初始化dp
        dp[0][1]=slices[0];
        dp[1][0]=0;
        dp[1][1]=Math.max(slices[0],slices[1]);
        for(int i=2;i<len;i++){               //对于每块饼
            for( int j=1; j<=(len+1)/3 && j<=i ; j++){  //假设这块饼是第几块饼，一个很奇怪的点是答案都没有j<=i; 这个条件可以减少一些循环
                dp[i][j]=Math.max(dp[i-1][j],dp[i-2][j-1]+slices[i]);
            }
        }
        return dp[len-1][(len+1)/3];
    }
}
