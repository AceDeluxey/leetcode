/**
 *  260. 只出现一次的数字 III
 *  有重复元素和缺失元素时都要考虑用异或运算，比如都是两个异或一遍就可以只剩下 a b各一次
 *  但是怎么从数中分出这两个，就要依靠最后的xorSUm中的情况，有1的位置就证明分成两组的话 a和b 这一位一个是0一个是1，
 *  就找到一位1，在这个位置上是1的异或在一起，可以得到a;在这个位置是0 异或起来可以得到b
 *  还有找一个数最低为1的位时，可以num&-num，因为负数是反过来以后+1，是0的位反过来+1还是0，和是0
 *  而1反过来 加1 是1，和就是1，就找到了最低的1
 *  1ms  97%
 */
public class class260 {
    public int[] singleNumber(int[] nums) {
        int xorSum = 0 ;
        for (int num:nums){
            xorSum = xorSum ^ num;
        }
        int lowb = xorSum & -xorSum;
        int sum1 =0 , sum2=0;
        for (int num:nums){
            if ((num &lowb) ==0){
                sum1 = sum1^num;
            } else{
                sum2 = sum2^num;
            }
        }
        return new int[]{sum1,sum2};
    }
}
