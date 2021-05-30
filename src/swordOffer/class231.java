package swordOffer;
/*
    231. 2 的幂
    给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
    如果存在一个整数 x 使得 n == 2x ，则认为 n 是 2 的幂次方。

    思路：对于2的幂次方，有(n&(n-1))==0,原因在于二进制数的表示法中，2的次幂只有最高位一位是1，
            而2的次幂-1最高位是0，其他低位是0，
            所以有(n&(n-1))==0
        1ms 100%
 */
public class class231 {
    public boolean isPowerOfTwo(int n) {
        return n<=0?false:(n&(n-1))==0;
    }
}
