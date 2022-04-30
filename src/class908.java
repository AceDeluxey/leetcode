/**
 * 908. 最小差值 I
 * 其实就是看最大值最小值差值与k的关系
 * 1ms 100%
 */
public class class908 {

    public int smallestRangeI(int[] nums, int k) {
        int max1 = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if( nums[i] > max1){
                max1 = nums[i];
            }
            if(nums[i] < min){
                min =  nums[i];
            }
        }
        return max1-min<=2*k?0:max1-min-2*k;
    }
}
