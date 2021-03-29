/**
 * 190. 颠倒二进制位
 * JAVA的int只有有符号数，所以颠倒二进制位时要用逻辑位移，也就是符号位也移动
 * 每次就移动n的最低位，先与1想与保证只有最低为有效，移动到指定位后
 * 与result相或，因为result本来是1,所以一次置一位
 * 100 68
 */
public class class190 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result=0;
        for(int i=0;i<32;i++){
            result |=(1&n)<<(31-i);
            n=n>>>1;
        }
        return result;
    }
}
