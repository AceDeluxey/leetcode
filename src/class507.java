/**
 * 507. 完美数
 *
 * 简单
 * 2ms 56%
 */

public class class507 {
    public boolean checkPerfectNumber(int num) {
        if(num==1){
            return false;
        }
        int sum = 1 ;

        for(int i =2 ; i <= Math.sqrt(num) ;i++) {
            if(num%i==0){
                sum = sum + (i+num/i);
            }
        }

        if(sum == num ){
            return true;
        } else{
            return false;
        }
    }
}
