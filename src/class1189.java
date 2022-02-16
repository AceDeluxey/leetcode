/**
 * 1189. “气球” 的最大数量
 * 简单 map都不用 用数据就行了
 * 2ms 86%
 */
public class class1189 {
    public int maxNumberOfBalloons(String text) {
        int nums[] = new int[5];
        for (char c : text.toCharArray()) {
            if (c == 'a') {
                nums[0]++;
            } else if (c == 'b') {
                nums[1]++;
            } else if (c == 'l') {
                nums[2]++;
            } else if (c == 'o') {
                nums[3]++;
            } else if (c == 'n') {
                nums[4]++;
            }
        }
        nums[2] /= 2;
        nums[3] /= 2;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            min=Math.min(min, nums[i]);
        }
        return min;
    }
}
