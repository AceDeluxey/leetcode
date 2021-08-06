import java.util.Arrays;

/**
 *         45. 跳跃游戏 II
 *         给你一个非负整数数组nums ，你最初位于数组的第一个位置
 *          数组中的每个元素代表你在该位置可以跳跃的最大长度。
             你的目标是使用最少的跳跃次数到达数组的最后一个位置。
             假设你总是可以到达数组的最后一个位置。

    思路：反过来动态规划。如果能直接到dp=1，如果不能就中转一下，反正后面的dp已经是最小值；要注意判断-1

        但是dp复杂度往往不是最低的揭发
        41ms 17%

 */
public class class45 {
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1);

        dp[nums.length - 1] = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= nums.length - 1) {
                dp[i] = 1;
            } else{
                int min = Integer.MAX_VALUE;
                for(int j=1;j<=nums[i];j++){
//                    不等于-1说明可以跳到
                    if(dp[j+i]!=-1){
                        min=Math.min(min,dp[i+j]+1);
                    }
                }

                dp[i]=min==Integer.MAX_VALUE?-1:min;
            }
        }

        return dp[0];
    }
}
