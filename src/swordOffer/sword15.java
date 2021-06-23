package swordOffer;

/**
        剑指 Offer 15. 二进制中1的个数
        请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中 1 的个数。例如，把 9表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。

        思路：循环无符号右移，与1与，如果还是1，就是最低位是1

        1ms 96%
 */
public class sword15 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int cnt =0;
        while (n != (n>>>1)){
            if( (n & 1) == 1){
                cnt ++;
            }
            n = n>>>1;
        }
        return cnt;
    }
}
