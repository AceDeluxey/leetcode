package swordOffer;

/**
 * 剑指 Offer 10- II. 青蛙跳台阶问题
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * method2:递归会超时
 * method1:用数组动态规划 100 5%
 * method3:在动规的基础上减少空间使用,用三个int 代替数组，100 24%
 */
public class sword10II {
    public int numWays(int n) {
    //method3:
        int res0=1,res1=1,res2=0;
        if(n==0||n==1){
            res2=1;
        }
        for(int i=2;i<n+1;i++){
            res2=(res1+res0)%1000000007;
            res0=res1;
            res1=res2;
        }

        return res2;
    /**
     * method1:动态规划
     * 求解fn可以分解为求解子问题fn-2+fn-1
     * 这个问题初始就可以知道最小子问题
     * 所以可以从下到上地求解，避免递归的冗余空间
       int []result=new int[n+1];
        result[0]=1;
        if(n!=0){
            result[1] = 1;
        }
        for(int i=2;i< result.length; i++){
            result[i]=(result[i-2]+result[i-1])%1000000007;
        }
        return result[n];
     */
        //method2:
//        if(n==0){
//            return 1;
//        }
//        if(n>2){
//            return numWays(n-1)+numWays(n-2);
//        } else if(n==2){
//            return 2;
//        } else if(n==1){
//            return 1;
//        } else{
//            return -1;
//        }
    }
}
