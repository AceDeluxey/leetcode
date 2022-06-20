/*
        887. 鸡蛋掉落
        题目描述有点问题，不应该是确定f的最小操作次数
        应该是在最坏的情况下，最小的操作次数是多少
        或者说在最优丢法下，最坏的情况
        比如一颗鸡蛋，只有一种丢法，它的最坏情况就是n
        也就是第一次扔n中的任一一层m，它的最坏情况要比较1-m和m+1到n哪个次数多，选次数多的即为最坏情况
        这样递归下去一直选最坏情况，就是第一次扔m的最坏情况
        总共有n层，算第一次扔n中的每一层的最坏情况的n种情况中的最小值


        methoD1: 暴力动规，用例超时
        8
        10000
 */
public class class887 {
    public int superEggDrop(int k, int n) {

        //method1:
        int [][]dp= new int [k+1][n+1];
        for(int i=0;i<n+1;i++){  //1个蛋，扔楼层数
            dp[1][i]=i;
        }
        for(int i=1;i<k+1;i++){  //一层楼，多少个蛋都是一次
            dp[i][1]=1;
        }

        for(int i=2;i<k+1;i++){
            for ( int j=2; j<n+1;j++){
                int min=Integer.MAX_VALUE;   //对于dp[i][j], 也就是j层楼丢i个蛋
                                            //那么根据第一个蛋丢的位置可以循环1到j层楼次计算最小是
                for(int m=1;m<=j;m++){
                    min=Math.min(min,1+Math.max(dp[i][m-1],dp[i-1][j-m]));
                }
                dp[i][j]=min;
            }
        }
        return dp[k][n];
    }
}
