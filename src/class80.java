/**
 * 80. 删除有序数组中的重复项 II
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 *  1ms 80%; 38.6M 46.62%
 *
 *  思路:双指针
 */


public class class80 {
    public int removeDuplicates(int[] nums) {
        int base=0,top=0;
        for(int i=0;i<nums.length-1; i++){

            if(nums[i] == nums[i+1]){
                if(top-base==1){   //当相邻元素相同，元素放置超过两个继续循环
                    continue;
                } else{
                    nums[++top]=nums[i];  //当相邻元素相同，没有超过两个放置元素
                }

            } else{      //当相邻元素不同，放到相应位置
                base=top+1;
                top=base;
                nums[base]=nums[i+1];

            }
        }
        return top+1;
    }
}
