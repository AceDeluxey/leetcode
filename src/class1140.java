/*
    1140. 石子游戏 II
    method2:想错了，没有考虑lee的水平最高
    method1:很巧妙的dp,倒着dp

    8ms 77%
 */

public class class1140 {
    public int stoneGameII(int[] piles) {
        int [][] dp = new int [piles.length][piles.length];
        //i行数代表从第几堆开始拿，j代表M
        int sum=0;
        for(int i=piles.length - 1; i >= 0; i--){
            sum+=piles[i];
            for (int j=piles.length - 1; j >= 0; j--) {
                 if(i+2*(j+1)>= piles.length){
                    dp[i][j]=sum;
                } else{
                    //因为我的j是M-1，所以优点拧巴
                    for (int k=1;k<=2*(j+1);k++){
                        dp[i][j]=Math.max(dp[i][j],sum-dp[i+k][Math.max(k,j+1)-1]);
                    }
                }
            }
        }
        return dp[0][0];
    }

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
