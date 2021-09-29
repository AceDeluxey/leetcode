/**
 53. 最大子序和

 思路：dp，算前缀和，对每个数，如果sum+num比num还小，说明把前面连到num上肯定不是最大，还不如重新从Num出发
        就这样，每次max一次

        O(n) 2ms 15%
 */
public class class53 {
    public int maxSubArray(int[] nums) {
        int result = -99999999 ;
        int pre = 0;
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            result = Math.max(pre, result);
        }
        return result;
    }
}
