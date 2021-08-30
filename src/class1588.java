/**
 1588. 所有奇数长度子数组的和:
     给你一个正整数数组arr，请你计算所有可能的奇数长度子数组的和。

     子数组 定义为原数组中的一个连续子序列。

     请你返回 arr中 所有奇数长度子数组的和

    思路：前缀和
        2ms 38%
 */
public class class1588 {
    public int sumOddLengthSubarrays(int[] arr) {
        int result = 0;

        int[] sum = new int[arr.length];
        sum[0] = arr[0];
        //求前缀和
        for (int i = 1; i < arr.length; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            //子数组的长度是j
            for (int j = 1; i + j -1 < arr.length; j += 2) {
                //加每个子数组的和

                result += sum[i + j - 1] - (i - 1 >= 0 ? sum[i - 1] : 0);
            }
        }
        return result;
    }
}
