/**
 * 153. 寻找旋转排序数组中的最小值
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
 * 若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 *
 * 给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 *
 * 思路：要什么二分法，遍历判断如果有一个元素小于循环的前一个和后一个就行
 *      这样复杂度也是On
 *
 *      0ms 100%; 38.1  14..2%
 */

public class class153 {
    public int findMin(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        for(int i=0;i<nums.length;i++){
            int index1=i-1;
            if(index1<0){
                index1 = nums.length - 1;
            }
            int index2=(i+1)% nums.length;
            if(nums[i]<nums[index1] && nums[i]<nums[index2] ){
                return nums[i];
            }
        }
        return -1;
    }
}
