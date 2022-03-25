/**
 * 172. 阶乘后的零
 * 阶乘里5的来源只有5和偶数相乘，或者10
 * 偶数多很多，所以数5就行了，5 每隔5次出现一个所以n/5
 * 然后还有25 2*25 3*25里面有两个5
 * 还有125的倍数
 * 最终 5 的个数就是 n / 5 + n / 25 + n / 125
 */
public class class172 {
    public int trailingZeroes(int n) {
        int res =0 ;
        while ( n>0){
            //为了防止溢出，所以不在分母上增加，在n上直接除减少
            res +=n/5;
            n=n/5;
        }
        return res;
    }
}
