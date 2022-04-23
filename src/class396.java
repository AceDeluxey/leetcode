/**
 * 396. 旋转函数
 * 3ms 98%
 */
public class class396 {
    public int maxRotateFunction(int[] nums) {
        int sum = 0;
        int temp = 0 ;
        for(int i =0;i < nums.length; i++){
            sum+=nums[i];
            temp += nums[i]*i;
        }
        int max = temp;
        for (int i = nums.length - 1; i >=0; i--) {
            temp += sum;
            temp -= nums.length*nums[i];
            max =Math.max(max,temp);
        }
        return max;
    }
}
