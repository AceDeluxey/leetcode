/**
    476. 数字的补数
    思路：首选数num有几位，然后构造一个几位的全1，与之异或即可
    0ms 100%
 */
public class class476 {
    public int findComplement(int num) {
        int heighbit = 0;
        for (int i = 0; i < 31; i++) {

            if ((num >>> i) > 0) {
                heighbit=i;
            } else{
                break;
            }
        }

        int mask = 0xFFFFFFFF>>>(32-heighbit-1);

        return mask^num;
    }
}
