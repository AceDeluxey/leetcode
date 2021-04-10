package swordOffer;
/*
    剑指 Offer 14- I. 剪绳子
    给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。

    思路：当成数学题做的
         因为x的平方肯定大于(x-1)(x+1),可以推测出切割的最大值应该是一个数的乘方乘以余数
         再加上提示n<=58,9*9=81；所以这个乘方数肯定小于等于9
         所以我们遍历9到1，看它由9到1可以乘方的数的最大值，同时要避免余数为1

        0ms 100%;

 */
public class sword14I {
    public int cuttingRope(int n) {
        int result=0;
        for( int i=9; i>=1 ; i--){
            if(n/i>0){
                double temp;
                if(n==i){         //相同
                    continue;
                }
                if(n%i==0){      //余数为0，直接为乘方数
                    temp=Math.pow(i,n/i);
                } else if(n%i==1){
                    if(n%i+i<n){        //余数为1时，要避免余数为1， 比如10= 3 * 3 *4; 本来时3*3*3*1，但是为了避免1
                        temp=Math.pow(i,n/i-1)*(n%i+i);
                    } else{
                        temp=Math.pow(i,n/i)*(n%i);
                    }
                } else{      //余数不为1，直接乘
                    temp=Math.pow(i,n/i)*(n%i);
                }

                if(temp>result){
                    result = (int)temp;
                }
            }
        }
        return result;
    }
}
