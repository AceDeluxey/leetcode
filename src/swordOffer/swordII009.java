package swordOffer;

import java.util.Arrays;

/**
 * 剑指 Offer II 009. 乘积小于 K 的子数组
 * 双指针就行了  因为越长的一段数组里面乘积越大 所以大了左边缩小 小了右边扩大就行了
 * 可以再做
 * 4ms 100%
 */
public class swordII009 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
//        Arrays.sort(nums);
//        int left =0 ,right = 1;
//        int len = nums.length;
//        int temp = nums[left];
//        int res = nums[0]<k?1:0;
//        if(nums.length == 1){
//            return res;
//        }
//        while(left != len-1){
//
//            while(temp < k ){
//
//                temp = temp *nums[right];
//                if(temp<k){
//                    res++;
//                }
//                if(right == len -1){
//                    break;
//                } else{
//                    right ++ ;
//                }
//            }
//
//            while(temp > k){
//                temp = temp /nums[left];
//                if(temp<k){
//                    res++;
//                }
//                if(left == len -1){
//                    break;
//                } else{
//                    left ++ ;
//                    if(nums[left]<k){
//                        res++;
//                    }
//                }
//            }
//        }
//        return res;

        int res = 0;
        int len = nums.length;
        int temp = 1;
        int i = 0;
        for (int j = 0; j < len; j++) {
            temp = temp * nums[j];
            while (i<=j && temp >= k) {
                temp/=nums[i++];
            }
            res += j - i + 1;
        }
        return res;
    }

}
