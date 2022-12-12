/**
 * 1781. 所有子字符串美丽值之和
 * 就是每遍历一次，要重新数一下最小的
 * 因为遍历的时候看不出最小的，首先不知道出现过没是不是1，然后当1变成2以后，不知道最小值是1还是2
 * 所以要重新数
 * 57 ms 76
 */
public class class1781 {
    public int beautySum(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] cnt = new int[26];
            int maxFreq = 0;
            for (int j = i; j < s.length(); j++) {
                cnt[s.charAt(j) - 'a']++;
                maxFreq = Math.max(maxFreq, cnt[s.charAt(j) - 'a']);
                int minFreq = s.length();
                for (int k = 0; k < 26; k++) {
                    if (cnt[k] > 0) {
                        minFreq = Math.min(minFreq, cnt[k]);
                    }
                }
                res += maxFreq - minFreq;
            }
        }
        return res;


    }
}
