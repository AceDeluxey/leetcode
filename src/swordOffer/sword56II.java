package swordOffer;

import java.util.Arrays;
/*/
    剑指 Offer 56 - II. 数组中数字出现的次数 II
    在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。

    思路：首先想到的肯定是HashMap,但是想用不同方法做
        因为除了一个数都是三个数一组，
        那么我们可以先排序这个数组，然后查看第i个数是否和i+2个数相同
        比如1112333
        当到2时，发现2和3不同，就直接返回2。因为如果有三个2，一定是相同的

     6ms 70%

 */
public class sword56II {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i< nums.length-1 ;i+=3){
            if(nums[i]!=nums[i+1]){
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }
}
