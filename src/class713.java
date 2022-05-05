/**
 * 713. 乘积小于 K 的子数组
 * 滑动窗口 值得做
 * 4ms 99%
 */
public class class713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0,right = 0  ;
        int product = 1;
        int res = 0 ;
        while(right<nums.length){

            product *= nums[right++];



            while (left < right && product>=k){
                product /= nums[left++];
            }

            res  += right-left;
        }
        return res;
    }

}