import java.util.HashSet;

/**
    869. 重新排序得到 2 的幂

    1ms 97%
 */
public class class869 {

    public boolean reorderedPowerOf2(int n) {
        String nstring = countDigts(n);
        for( int i = 1; i <= 1e9; i <<= 1){
            if(nstring.equals(countDigts(i))){
                return true;
            }
        }
        return  false;
    }



    //统计每一个数字出现多少次
    private String countDigts(int n){
        char [] digits = new char[10];
        while(n>0){
            digits[n%10]++;
            n= n/10;
        }
        return new String(digits);
    }
}
