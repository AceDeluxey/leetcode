/**
 * 788. 旋转数字
 */
public class class788 {
    public int rotatedDigits(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            int val = i;
            int count = 0;
            while (val > 0) {
                int temp = val % 10;
                if (temp == 2 || temp == 5 || temp == 6 || temp == 9) {
                    count = 1;
                } else if (temp == 3 || temp == 4 || temp == 7) {
                    count = 0;
                    break;
                }
                val = val / 10;
            }
            ans += count;
        }
        return ans;
    }
}
