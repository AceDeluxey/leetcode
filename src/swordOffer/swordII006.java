package swordOffer;

/**
 * 剑指 Offer II 006. 排序数组中两个数字之和
 *
 * 双指针 遍历一次 两边收缩就好了 0ms 100%
 */
public class swordII006 {
    public int[] twoSum(int[] numbers, int target) {
        int [] res = new int [2];
        int left = 0 ,  right = numbers.length-1;
        while(left != right){
            while(left != right && numbers[left] + numbers[right]>target){
                right--;
            }
            if(numbers[left] + numbers[right]==target){
                res[0] = left;
                res[1] = right;
                break;
            } else{
                left++;
            }
        }
        return res;
    }
}
