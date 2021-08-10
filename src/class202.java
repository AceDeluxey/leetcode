import java.util.HashSet;


/**
        202. 快乐数
        编写一个算法来判断一个数 n 是不是快乐数。

        思路：简单  1ms 98%
 */
public class class202 {
    HashSet<Integer> set = new HashSet<>();
    public boolean isHappy(int n) {

        while (true){
            if(n == 1){
                return true;
            }
            n = calSum(n);

            //说明出现循环
            if(set.contains(n)){
                return false;
            } else{
                set.add(n);
            }
        }
    }
    private int calSum(int n){
        int sum =0;
        while(n>0){
            int temp = n%10;
            sum+=temp*temp;
            n/=10;
        }
        return sum;
    }
}
