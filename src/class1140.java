/*
    1140. 石子游戏 II
    method2:想错了，没有考虑lee的水平最高
    method1:很巧妙的dp,倒着dp

    8ms 77%
 */

public class class1140 {
    /**
     * 2023 02 22 重新写
     * 用的DFS
     * 学到了一点就是int[]初始化一般为0,有时候不好判断是否遍历过
     * 这时候可以用Integer 因为初始化是Null,这样就可以判断
     * 而且实际上来看,这样DFS其实和dp没什么区别,区别在于这是正着去的
     * 只用dp是倒着的
     * 3ms 81%
     * 上一次写是2021 5月
     */
    int len;
    int s[];
    Integer dp[][];

    public int stoneGameII(int[] piles) {
//        就不用dp写了
//        int len = piles.length;
//        int dp [][] = new int[][];
        /**
         * 这次用dfs写吧
         */
        len = piles.length;
        s = new int[len+1];
        //第一维是从哪里开始,第二维度是M[1,len]
        dp = new Integer[len][len + 1];

        //求前缀和,要多一位,第一位是0,这样才能求所有的长度
        for (int i = 0; i < len; i++) {
            s[i] = s[i - 1] + piles[i];
        }
        return dfs(0, 1);
    }

    //玩家从index出手,拿M个能拿到的最大
    private int dfs(int i, int m) {
        /**
         * 为什么是s[len] - s[i],因为前缀和的数组长度是len+1,
         * 等于比i提前一位 所以不再是s[len-1]-s[i-1]
         */
        if (m * 2 >= len - i) {
            return s[len] - s[i];
        }
        if (dp[i][m] != null) {
            return dp[i][m];
        }
        int res = 0;
        //遍历每一种可能的x
        for (int x = 1; x <= m * 2; ++x) {
            // 保证对手也是最优
            res = Math.max(res, s[len] - s[i] - dfs(i + x, Math.max(m, x)));
        }
        return dp[i][m] = res;


    }
    //method1
//    public int stoneGameII(int[] piles) {
//        int [][] dp = new int [piles.length][piles.length];
//        //i行数代表从第几堆开始拿，j代表M
//        int sum=0;
//        for(int i=piles.length - 1; i >= 0; i--){
//            sum+=piles[i];
//            for (int j=piles.length - 1; j >= 0; j--) {
//                 if(i+2*(j+1)>= piles.length){
//                    dp[i][j]=sum;
//                } else{
//                    //因为我的j是M-1，所以有点拧巴
//                    for (int k=1;k<=2*(j+1);k++){
//                        //这样最大的原因是，我们拿了k个，到对手从i+k开始拿，因为对手也最优，所以我们能拿的最大值就是sum-对手的最大值
//                        dp[i][j]=Math.max(dp[i][j],sum-dp[i+k][Math.max(k,j+1)-1]);
//                    }
//                }
//            }
//        }
//        return dp[0][0];
//    }

//    method2:带记忆搜索
//    int memory [][];
//    public int stoneGameII(int[] piles) {
//        int max=0;
//        memory = new int[piles.length][piles.length];
//        for( int i=1; i<=2;i++){
//            max=Math.max(max,search(i,0,piles,1));
//        }
//        return max;
//    }
//    private int search(int thisNum,int startIndex,int [] piles,int M){
//        System.out.print(thisNum);
//        System.out.print(' ');
//        System.out.println(startIndex);
//        int sum=0;
//        int max=0;
//        int i;
//        for(  i=0; i<thisNum;i++){
//            sum+=piles[startIndex+i];
//        }
//        max=Math.max(max, sum);
//        startIndex+=thisNum;
//
//        M=Math.max(thisNum,M);
//        int j,k;
//        for( j=1;j<=2*M && startIndex+j<=piles.length; j++ ){
//            int M2=Math.max(j,M);
//            for(  k=1;k<2*M2 && startIndex+j+k<=piles.length; k++){
//                if(memory[startIndex+j][k]!=0){
//                    max=Math.max(max,sum+memory[startIndex+j][k]);
//                } else{
//                    max=Math.max(max,sum+search(k,startIndex+j,piles,M2));
//                }
//            }
//        }
//        return max;
//    }
}
