import java.util.Arrays;

/**
 * 1984. 学生分数的最小差值
 * 排序就完事
 */
public class class1984 {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length-(k-1); i++){
            min = Math.min(min, nums[i+(k-1)]-nums[i]);
        }
        return min;
    }
}
