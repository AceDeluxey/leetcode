package swordOffer;
/**
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 * 思路：二分查找
 *  但二分查找的细节还有点问题
 *  100,93
 */

public class sword53 {
    public int missingNumber(int[] nums) {

        int low=0,high=nums.length-1;
        while(low<high) {  //临界条件是 low==high，就可以判断low是缺少的那位
            int mid = (low + high) / 2;
            if (nums[mid] > mid) {
                high=mid;  //不+1是因为此处不能判断high是不是缺少那位
            } else {
                low=mid+1;  //+1是因为只要相等就说明该位不缺少
            }
        }
        return low==nums[low]?low+1:low;
    }
}
