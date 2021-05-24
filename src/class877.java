
/*
    877. 石子游戏
    亚历克斯和李用几堆石子在做游戏。偶数堆石子排成一行，每堆都有正整数颗石子 piles[i] 。

    思路：其实是递归思想，对于Piles来说，转移方程见代码中
        但是用的是带记忆的递归实现的,因为递归其实是不断缩小边界的情况

     10ms 17.2%

 */
public class class877 {
    int [][]max ;
    public boolean stoneGame(int[] piles) {
        max=new int[piles.length][piles.length];
        int sum=0;
        for( int i=0;i<piles.length; i++){
            sum+=piles[i];
        }
        int Alex=findMax(piles,0,piles.length-1);
        return Alex>sum-Alex;
    }
    public int  findMax(int[] piles , int start , int end){
        if(start == end-1){
            return  Math.max(piles[start],piles[end]);
        }
        if(max[start][end]!=0){
            return max[start][end];
        } else{

            //转移方程
            int max1=Math.max(piles[start]+findMax(piles,start+2,end),piles[start]+findMax(piles,start+1,end-1));
            int max2=Math.max(piles[end]+findMax(piles,start,end-2),piles[end]+findMax(piles,start+1,end-1));
            max[start][end]=Math.max(max1,max2);
            return max[start][end];
        }
    }
}
