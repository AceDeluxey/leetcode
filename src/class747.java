/**
 * 747. 至少是其他数字两倍的最大数
 *
 * 思路： 遍历中寻找最大值和第二大的值，比较这两个数就可以
 *
 * 0ms 100%
 */
public class class747 {
    public int dominantIndex(int[] nums) {
        //最大值
        int a = Integer.MIN_VALUE;
        //最大坐标
        int index1 = -1;
        //第二大值
        int b = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > a) {
                //如果最大的数改变了，那么将最大数替换到第二大的数上
                b = a;
                a =  nums [i];
                index1 = i;
            } else if(nums[i] > b){
                //最大数没有替换，第二大的数被替换
                b =  nums [i];
            }

        }
        return a >= b*2?index1:-1;
    }
}
