/**
 * 268. 丢失的数字
 * 用数学公式很简单
 */
public class class268 {
    public int missingNumber(int[] nums) {
        int sum = (1 + nums.length) * nums.length / 2;
        for (int i = 0; i < nums.length; i++) {
            sum -=nums[i];
        }
        return sum;
    }
}
