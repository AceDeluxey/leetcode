
/*
    1486. 数组异或操作

    给你两个整数，n 和 start 。
    数组 nums 定义为：nums[i] = start + 2*i（下标从 0 开始）且 n == nums.length
    请返回 nums 中所有元素按位异或（XOR）后得到的结果。

    很简单

    0ms 100%


 */
public class class1486 {
    public int xorOperation(int n, int start) {
        int result=0;
        for(int i=0;i<n;i++){
            int temp=start + 2*i;
            result ^=temp;
        }
        return result;
    }
}
