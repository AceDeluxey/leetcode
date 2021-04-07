/**
 * 81. 搜索旋转排序数组 II
 * 已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转 ，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。如果 nums 中存在这个目标值 target ，则返回 true ，否则返回 false 。
 *
 *
 * method1: 二分查找，细节太多了改不出来
 * method2:  暴力，由于On，效果还是很好，0ms 100%;38.4M 20%;
 *

 */

public class class81 {
    public boolean search(int[] nums, int target) {
        //method2:暴力
        for(int i=0;i<nums.length; i++){
            if(target == nums[i]){
                return true;
            }
        }
        return false;
        //meThod1:二分
//        int low=0,high=nums.length-1;
//        while(low<=high){
//            int mid=(low+high)/2;
//            if(target==nums[mid]){
//                return true;
//            }
//            if(target>=nums[low]){
//                if(nums[low]<=nums[mid] && target > nums[mid]){     //在第一段中
//                       low=mid+1;
//                } else{
//                       high=mid-1;
//                }
//            } else if(target<=nums[high]){
//                if(nums[high]>=nums[mid] && target < nums[mid]){  //在第二段中
//                        high = mid-1;
//                } else{
//                        low=mid+1;
//                }
//            }
//        }
//        return false;
    }
}
