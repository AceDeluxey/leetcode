/*
    1685. 有序数组中差绝对值之和
    给你一个 非递减有序整数数组num。
    请你建立并返回一个整数数组result，它跟nums长度相同，且result[i]等于nums[i]与数组中所有其他元素差的绝对值之和。

    思路：因为有序，所以第i位是i后面所有数的sum-n1个i，+上n2个i减去前面数的sum

        4ms 79%
 */

public class class1685 {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int sum=0;
        int []result = new int [nums.length];
        for( int i = 0;i<nums.length;i++){
            sum += nums[i];      //先计算右边的和
        }
        int sum_left=0;    //左边的和
        for( int i =0 ;i < nums.length ;i++){
            result[i]=sum-(nums.length-i)*nums[i];
            sum -=nums[i];
            if(i-1>=0){
                sum_left +=nums[i-1];
                result[i]+=i*nums[i]-sum_left;
            }
        }
        return result;
    }
}
