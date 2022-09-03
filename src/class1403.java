import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1403. 非递增顺序的最小子序列
 * 排序 模拟
 * 3ms 94%
 */
public class class1403 {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int temp = 0;
        int i = nums.length - 1;
        for (; i >= 0; i--) {
            temp += nums[i];
            if (temp > sum / 2) {
                break;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int j = nums.length - 1; j >= i; j--) {
            list.add(nums[j]);
        }
        return list;
    }
}
