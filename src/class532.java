import java.util.Arrays;

/**
 * 532. 数组中的 k-diff 数对
 * 排序 条件
 * 6ms 84%
 * -
 */
public class class532 {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if(i>=1 && nums[i-1]== nums[i]){
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == nums[i] + k) {
                    res++;
                    break;
                } else if (nums[j] > nums[i] + k) {
                    break;
                }
            }
        }
        return res;
    }
}
