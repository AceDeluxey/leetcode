import java.util.HashSet;
import java.util.Set;

/**
 * 2395. 和相等的子数组
 * 1ms 80%
 */
public class class2395 {
    public boolean findSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length-1; i++) {
            int temp = nums[i]+nums[i+1];
            if(set.contains(temp)){
                return true;
            } else{
                set.add(temp);
            }
        }
        return false;
    }

}
