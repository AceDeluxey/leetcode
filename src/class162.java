/**
 * 162. 寻找峰值
 * 二分
 */
public class class162 {
    public int findPeakElement(int[] nums) {
        int left = 0 , right = nums.length;
        while(left<right){
            int mid = (left - right)/2 +right;
            if(nums[mid]>nums[mid+1]){
                right = mid ;
            } else {
                left = mid+1;
            }
        }
        return left;
    }
}
