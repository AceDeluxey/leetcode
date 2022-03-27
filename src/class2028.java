import java.util.Arrays;
import java.util.List;

/**
 * 2028. 找出缺失的观测数据
 * 除的值取地板，给每个填上，然后加remainder个1就行
 *
 * 4ms 36$%
 */
public class class2028 {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int [] res = new int[n];
        int sum = mean* (rolls.length + n);
        for( int i = 0 ;i< rolls.length ;i++){
            sum -= rolls[i];
        }

        //不可能完成
        if(sum<n || sum>6*n){
            return new int[0];
        }
        int l= (int) Math.floor(sum/n);
        int remainder = sum%n;
        Arrays.fill(res,l);
        for(int i=0;i<remainder;i++){
            res[i]++;
        }
        return res;
    }
}
