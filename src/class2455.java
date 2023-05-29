/**
 * 2455. 可被三整除的偶数的平均值
 * 1ms 54
 * 简单
 */
public class class2455 {
    public int averageValue(int[] nums) {
        long sum =0;
        int cnt =0;
        for (int i =0 ;i<nums.length;i++){
            if(nums[i]%2 ==0){
                if(nums[i]%3 ==0){
                    sum += nums[i];
                    cnt++;
                }
            }
        }
        return cnt==0?0:(int) (sum/cnt);
    }
}
