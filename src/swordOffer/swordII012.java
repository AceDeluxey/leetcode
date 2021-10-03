package swordOffer;

/**
     剑指 Offer II 012. 左右两边子数组的和相等
        给你一个整数数组 nums ，请计算数组的 中心下标 。

    思路：很简单，但是要考虑特判
        On 2ms 36%
 */
public class swordII012 {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        int pre = 0;

        if (sum - nums[0] == 0) {
            return 0;
        }


        for (int i = 0; i < nums.length - 1; i++) {
            pre += nums[i];
            if (pre == sum - pre - nums[i + 1]) {
                return i + 1;
            }
        }

        if (sum - nums[nums.length - 1] == 0) {
            return nums.length - 1;
        }
        return -1;
    }
}
