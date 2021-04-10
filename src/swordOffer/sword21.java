package swordOffer;
/*
       剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
       输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。

        思路: 我觉得题目是有问题的，既然说奇数要位于数组的前半部分，那肯定奇数偶数要有一半一半才对
              这样直接调换顺序就行，结果给我一个这个[1,3,5]
              那就只能理解为奇数放在偶数前面
              用一个新数组，用两个index一次遍历
              2ms 98.07%; 48.1M 5.4%
 */
public class sword21 {
    public int[] exchange(int[] nums) {
        int result []= new int [nums.length];
        int index1=0,index2=nums.length-1;
        for(int i=0; i<nums.length;i++){
            if(nums[i]%2==0){
                result[index2--]=nums[i];
            } else{
                result[index1++]=nums[i];
            }
        }
        return result;
//        int index1=0,index2=nums.length-1;
//        while(index1 < index2){
//            while(nums[index1]%2==1 && index1 < nums.length/2){
//                index1++;
//            }
//            while(nums[index2]%2==0 && index2 > nums.length/2){
//                index2--;
//            }
//            int temp=nums[index1];
//            nums[index1]=nums[index2];
//            nums[index2]=temp;
//        }

//       return nums;
    }
}
