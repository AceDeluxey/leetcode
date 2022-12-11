/**
 * 1827. 最少操作使数组递增
 * 很简单
 * 3ms
 * on
 */
public class class1827 {
    public int minOperations(int[] nums) {
        int res=0;
        if(nums.length==1){
            return 0;
        }
        for(int i=1;i<nums.length;i++){
            if(nums[i]<=nums[i-1]){
                res+=nums[i-1]+1-nums[i];
                nums[i]=nums[i-1]+1;

            }
        }
        return res;
    }
}
