
/*
        55. 跳跃游戏
            给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
            数组中的每个元素代表你在该位置可以跳跃的最大长度。
            判断你是否能够到达最后一个下标。

        思路：暴力破解
        1106ms 5%, 给我整笑了
 */
public class class55 {
    public boolean canJump(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        visited[0] = true;
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                for (int j = 0; j <= nums[i]; j++) {
                    if (i + j < nums.length) {
                        visited[i + j] = true;
                    }
                }
            }
        }
        return visited[nums.length - 1];
    }
}
