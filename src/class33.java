/*
  33. 搜索旋转排序数组
    整数数组 nums 按升序排列，数组中的值 互不相同 。

    在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。

    给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 

    思路: 就是二分法，但是边界条件还是很难处理，参考了答案。
          二分法问题还是挺大的。

          0ms 100% ; 37.8 M 70.6%

 */


public class class33 {
    public int search(int[] nums, int target) {
        if(nums[0] == target){   //判断首位的特殊情况
            return 0;
        }
        if(nums[nums.length - 1] == target){
            return nums.length-1;
        }
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (target >= nums[low]) {           //target在前半段
                if (nums[low] <=nums[mid] && target > nums[mid]) {
                    low = mid + 1;          //特殊情况是mid 也在前半段，但mid在target前面
                } else {
                    high = mid - 1  ;
                }
            } else if (target <= nums[high]) {   //target在后半段
                if (nums[high] >= nums[mid] && target < nums[mid]) {
                    high = mid  -1;         //特殊情况是mid 也在后半段，但target在mid前面
                } else {
                    low = mid + 1 ;
                }
            } else{
                return -1;
            }
        }
        return -1;
    }
}
