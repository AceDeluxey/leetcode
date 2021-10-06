import java.util.Arrays;


/**
    414. 第三大的数
    给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。

    简单
    OlognN 1ms 97%
 */
public class class414 {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int num = 3;
        int index = nums.length - 1;
        int result = 0;

        //排序后数三个
        while (num > 0 && index >= 0) {
            if (index == nums.length - 1 || nums[index] != nums[index + 1]) {
                result = nums[index];
                num--;
            }
            index--;
        }
        //数完说明有第三大，否则没有
        return num == 0 ? result : nums[nums.length - 1];
    }
}
