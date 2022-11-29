/**
 * 1758. 生成交替二进制字符串的最少操作数
 * 模拟
 */
public class class1758 {
    public int minOperations(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != (char) ('0' + i % 2)) {
                cnt++;
            }
        }
        return Math.min(cnt, s.length() - cnt);

    }
}
