import java.util.HashMap;
import java.util.Map;

/**
 *1218. 最长定差子序列
 *dp,也是比较巧妙的dp，dp第二位代表的是状态
 * 还有关于多个dp[pre]的情况，因为不断更新，所以pre肯定是最近的那个，最近的比远的只会更长，所以最近的就是最优情况
 * dp[i][j]代表前i个数，当第i位状态为j时，最大子序列长度
 * j为0代表，i位不取; j为1代表取i位
 *
 * 60 ms 5% On
 */
public class class1218 {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> map = new HashMap<>();
        int[][] dp = new int[arr.length][2];

        dp[0][0] = 0;
        dp[0][1] = 1;
        map.put(arr[0], 0);
        for (int i = 1; i < arr.length; i++) {

            //不取
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);

            //取当前
            int pre = arr[i] - difference;
            if (map.containsKey(pre)) {
                dp[i][1] =  dp[map.get(pre)][1] + 1;
            } else {
                dp[i][1] = 1;
            }
            map.put(arr[i], i);
        }

        return Math.max(dp[dp.length - 1][0], dp[dp.length - 1][1]);
    }
}
