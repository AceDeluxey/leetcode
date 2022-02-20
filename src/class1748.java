import java.util.HashSet;
import java.util.Set;

/**
 * 1748. 唯一元素的和
 * 0ms 100%
 */
public class class1748 {
    public int sumOfUnique(int[] nums) {
        int sum = 0;
        int count [] = new int[nums.length+1];
        for(int i = 0; i < nums.length; i++){
            count[nums[i]] += 1;
            if(count[nums[i]]==1){
                sum += nums[i];
            } else if(count[nums[i]]==2){
                sum -= nums[i];
            }
        }
        return sum;
    }
}
