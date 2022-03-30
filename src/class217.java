import java.util.Arrays;

/**
 * 217. 存在重复元素
 * 18ms 38.7%
 */
public class class217 {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i-1]){
                return true;
            }
        }
        return false;
    }
}
