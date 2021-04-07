package swordOffer;

/**
 * 剑指 Offer 47. 礼物的最大价值
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 *
 * 思路：method1递归会有很多冗余循环，超时
 *
 *      method2:用来dp思想，从起点到点n的最大值，可以划分为从起点到n点上方和左方的最大值中的最大值+n点的值
 *              所以循环算出每行、每列的最大值，最后可以得到终点最大值
 *
 * 4ms 15% ; 41M 82%

 */
public class sword47 {
    //method1:dp
    public int maxValue(int[][] grid){
        int [][]dp=new int [grid.length][grid[0].length];
        if(grid.length==1 && grid[0].length == 1){
            return grid[0][0];
        }
        int x=0,y=0;
        while(x<grid[0].length || y<grid.length ){
            if(x==0 && y==0){            //初始化第一行和第一列
                dp[0][0]=grid[0][0];
                for(int i=1;i<grid[0].length; i++){
                    dp[0][i] = dp[0][i-1]+grid[0][i];
                }
                for(int i=1;i<grid.length; i++){
                    dp[i][0] = dp[i-1][0]+grid[i][0];
                }
                x++;
                y++;
                if(dp[grid.length-1][grid[0].length-1]>0){       //只有一行的情况
                    return dp[grid.length - 1][grid[0].length - 1];
                }
            } else{
                if(x<grid[0].length){           //以x+1，y+1为开始搜索该行该列
                    for(int i=x;i<grid[0].length; i++){
                        dp[y][i] = Math.max(Math.max(dp[y][i-1],dp[y-1][i])+grid[y][i],dp[y][i]);
                    }
                }
                if(y<grid.length){
                    for(int i=y;i<grid.length; i++){
                        dp[i][x] = Math.max(Math.max(dp[i-1][x],dp[i][x-1]) +grid[i][x],dp[i][x]);
                    }
                }
                if(x== grid[0].length -1  || y == grid.length -1 ){   //有一边到底说明终点已经遍历
                    break;
                }
                x++;
                y++;
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }

    //method2:递归
//    public int maxValue(int[][] grid) {
//        return search(0,0,grid);
//    }
//    public int search(int x,int y,int[][] grid){
//        if(x>=grid[0].length || y>=grid.length){
//            return 0 ;
//        }
//        return Math.max(search(x,y+1,grid),search(x+1,y,grid))+grid[y][x];
//    }
}
