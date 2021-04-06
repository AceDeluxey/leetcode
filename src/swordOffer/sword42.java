package swordOffer;
/**
 * 剑指 Offer 42. 连续子数组的最大和
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * 要求时间复杂度为O(n)。
 *
 * 思路：简单动规
 *      当只有一个元素时，最大和就是该元素；
 *      当有两个元素时，判断第一个元素是否大于0，如果大于0，则以第二个元素结尾的字串最大值就是第一个元素+第二个元素
 *      如果小于0，则以第二个元素结尾的字串最大值就是第二个元素
 *       这样就可以将问题简化为，判断每一个元素为结尾的字符串，只需要判断该元素与前一位的dp的大小关系
 *
 * 1ms 98%; 44.9M 55.4%
 */


public class sword42 {
    public int maxSubArray(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int dp=nums[0];
        int result=dp;
        for(int i=1;i<nums.length;i++){
            if(dp<0){
                dp=nums[i];
            } else{
                dp+=nums[i];
            }
            if(dp>result){
                result=dp;
            }
        }
        return result;
    }
}
