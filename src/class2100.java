import java.util.ArrayList;
import java.util.List;
/**
 * 2100. 适合打劫银行的日子
 * DP 算两边 i位置连续最大天数就可以了
 * 7ms 79%
 */
public class class2100 {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int len = security.length;
        int left [ ]  = new int[security.length];
        int right [ ]  = new int[security.length];
        left[0]=1;
        right[len-1]=1;
        for(int i = 1; i < len; i++){
            if(security[i-1]>=security[i]){
                left[i]=left[i-1]+1;
            } else{
                left[i] = 1;
            }
        }
        for( int i =len-2;i>=0;i--){
            if(security[i]<=security[i+1]){
                right[i] = right[i+1] + 1;
            } else{
                right[i] = 1;
            }
        }

        List<Integer> res = new ArrayList<>();
        for(int i = time; i <=len-time-1; i++){
            if(time==0){
                res.add(i);
                continue;
            }
            if(left[i]>=time+1 && right[i] >= time+1){
                res.add(i);
            }
        }
        return res;
    }
}
