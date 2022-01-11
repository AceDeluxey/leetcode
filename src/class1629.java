import java.util.List;

/**
 * 1629. 按键持续时间最长的键
 *
 * 思路：就是找最大值 很简单
 * 1ms 82%
 */
public class class1629 {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char res = 'a';
        int max = -1;
        for (int i = 0; i < releaseTimes.length; i++) {
            int time = 0;
            if (i == 0) {
                time = releaseTimes[i];
            } else {
                time = releaseTimes[i] - releaseTimes[i - 1];
            }
            if (time > max) {
                max = time;
                res = keysPressed.charAt(i);
            } else if (time == max) {
                char temp = keysPressed.charAt(i);
                if (res < temp) {
                    res = temp;
                }
            }
        }
        return res;
    }
}
