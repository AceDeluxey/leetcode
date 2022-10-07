/**
 * 1800. 最大升序子数组和
 * 很简单 模拟
 */
public class class1800 {
    public int maxAscendingSum(int[] nums) {
        int res =0 ;
        int temp = nums[0] ;
        for(int i=1;i<nums.length;i++){
            if (nums[i]>nums[i-1]){
                temp += nums[i];
            } else{
                res = Math.max(temp,res);
                temp =  nums[i];
            }
        }
        res = Math.max(temp,res);
        return res;
    }
}
