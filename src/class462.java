import java.util.Arrays;

/**
 * 462. 最少移动次数使数组元素相等 II
 * 先还以为移动到离平均数最近的整数应该是最好，没想到直觉错了，是都移动到中位数最好
 */
public class class462 {
    public int minMoves2(int[] nums) {
//        int sum = 0;
//        for(int i = 0; i < nums.length; i++){
//            sum+=nums[i];
//        }
//        double ave = sum/ nums.length;
//        int up = (int) Math.floor(ave);
//        int down = (int) Math.ceil(ave);
//
//        int res1=0,res2=0;
//        for(int i = 0; i < nums.length; i++){
//            res1 += Math.abs(nums[i]-up);
//            res2 += Math.abs(nums[i]-down);
//        }
//        return Math.min(res1,res2);
        Arrays.sort(nums);
        int n = nums.length, ret = 0, x = nums[n / 2];
        for (int i = 0; i < n; i++) {
            ret += Math.abs(nums[i] - x);
        }
        return ret;

    }
}
