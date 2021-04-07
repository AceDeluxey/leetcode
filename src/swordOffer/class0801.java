package swordOffer;

/**
 * 面试题 08.01. 三步问题
 * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。
 * 实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
 *
 *  88%，72%,空间上还是用Int代替了数组节省空间
 */
public class class0801 {
    public int waysToStep(int n) {
        int res0=1,res1 = 1,res2=2,res3=1;
        if(n==0||n==1){
            res3=1;
        } else if(n==2){
            res3=2;
        } else{
            res3=-1;
        }
        for(int i=3;i<n+1;i++){
            //这里为了防止越界，要先加两个取一次模，再相加取模
            //防止的是其中两个值都不超过107,但是相加就超过但是没有越界，再加第三个就越界的情况
            //但是只是为了过检查，实际可能出现三个数都接近107？然后任意两个相加就越界了，这样就没有效果了
            res3=((res0+res1)%1000000007+res2)%1000000007;
            res0=res1;
            res1=res2;
            res2=res3;
        }
        return res3;
    }
}