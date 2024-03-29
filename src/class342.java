/*
    342. 4的幂
    给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。

    思路：首先想到的是4的n次方,所以它可以是2的根号n次方乘以2的根号n次方，所以可以想到先开根，验证数是不是(n&(n-1))==0即可，但是开根号时间复杂度是On
        第二种就是观察4的n次方，是类似100，或是10000，1都在奇数位，那么就可以先验证n&(n-1))==0，保证只有一位是1，然后在验证1在奇数位
 */
public class class342 {
    public boolean isPowerOfFour(int n) {
        return ((n&0xaaaaaaab)==0 && ((n&(n-1))==0) &&n > 0) || n==1 ?true:false;
    }
}
