/**
 *      66. 加一
         给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
         最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
         你可以假设除了整数 0 之外，这个整数不会以零开头。

        思路：进位，先算一遍，如果最后进位还是1，说明多了一位，重新创建数组
        0ms 100%
 */
public class class66 {
    public int[] plusOne(int[] digits) {
        //进位
        int add =0,temp=0;
        for(int i=digits.length-1 ; i>=0; i--){
            if(i==digits.length-1){
                temp = digits[i] + 1 +add;
            } else{
                temp = digits[i] +add;
            }
            if(temp>=10){
                add =1;
                digits[i] = temp-10;
            } else{
                add=0;
                digits[i] = temp;
            }
        }
        if(add==0){
            return digits;
        }
        int [] digits2 = new int[digits.length+1];
        digits2[0]=add;
        for( int i=0 ;i < digits.length; i++){
            digits2[i+1] = digits[i];
        }
        return digits2;
    }
}
