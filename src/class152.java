/**
    152. 乘积最大子数组
    给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。

    思路：很特别的一道题，是二维dp
        按照经验来说dp[i]代表i结尾的子数组的最大值就够了，但是这题友负数
        如果nums[i]是负数，那么要乘以前面的最小值，不是最大值，所以要分为max和min两个dp数组
        On 2ms 82.5%
 */
public class class152 {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                max[0] = nums[i];
                min[0] = nums[i];
            } else {
                //如果是正值，那么我们希望更大，自然是乘最大值；如果是负数，那么乘以最小的数是最大
                max[i] = nums[i] > 0 ? Math.max(max[i - 1] * nums[i], nums[i]) : Math.max(min[i - 1] * nums[i], nums[i]);
                min[i] = nums[i] > 0 ? Math.min(nums[i], nums[i] * min[i-1]) : Math.min(max[i - 1] * nums[i], nums[i]);
                if (max[i] > res) {
                    res = max[i];
                }
            }
        }
        return res;
    }
}
