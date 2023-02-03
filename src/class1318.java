/**
 * 1318. 或运算的最小翻转次数
 * 位运算
 * 判断每一位和最低位
 * 还是比较值得做的
 *
 */
public class class1318 {
    public int minFlips(int a, int b, int c) {
        int res =0 ;
        for(int i =0 ; i<31;i++){
            //可以这么写，但是这么写要加if判断
//            int bit_a = a & (1<<i);
//            int bit_b = b & (1<<i);
//            int bit_c = c & (1<<i);
            //这么写移动到最低位，比较号比较

            int bit_a = (a >> i) & 1;
            int bit_b = (b >> i) & 1;
            int bit_c = (c >> i) & 1;
            if(bit_c ==0 ){
                res +=bit_a+bit_b;
            } else{
                if(!(bit_a==1 || bit_b==1)){
                    res++;
                }

            }

        }
        return  res;
    }
}
