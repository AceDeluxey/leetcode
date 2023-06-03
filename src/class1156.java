/**
 *
 * 1156. 单字符重复子串的最大长度
 * 真是写复杂了
 *思路其实就是双指针
 * 按照这个https://leetcode.cn/problems/swap-for-longest-repeated-character-substring/solution/python3javacgotypescript-yi-ti-yi-jie-sh-uq9g/
 * 就是我写的有点问题 搜完一次不应该是从右侧，应该是从中间，也就是第一次不同的地方开始第二次搜索
 * 脑壳有点昏的时候写的
 * 没写完
 *
 */
public class class1156 {
    public static void main(String[] args) {
        String s = "bbababaaaa";
        class1156 test = new class1156();
        test.maxRepOpt1(s);
    }
    public int maxRepOpt1(String text) {
        int num[] = new int[26];
        int temp[] = new int[26];
        int left = 0;
        if (text.length() == 1) {
            return 1;
        }
        int len = text.length();
        for (int i = 0; i < len; i++) {
            num[text.charAt(i) - 'a']++;
        }
        int res = 1;
        boolean use = false;
        char last = text.charAt(0);
        temp[last-'a'] =1;
        for (int i = 1; i < len; i++) {
            if (text.charAt(i) == last) {
                int index = text.charAt(i) - 'a';
                if (num[index] <= temp[index]){
                    left = i;
                    use = false;
                    temp = new int[26];
                    temp[text.charAt(left)-'a']++;
                    last = text.charAt(left);
                    continue;
                }

                int l = i - left + 1;
                res = Math.max(l, res);
                temp[text.charAt(i) - 'a']++;
                last = text.charAt(i);
            } else {
                if (!use) {
                    int index = text.charAt(i-1) - 'a';
                    if (num[index] > temp[index]) {
                        int l = i - left + 1;
                        res = Math.max(l, res);
                        use = true;
                        last = text.charAt(i-1);
                        temp[text.charAt(i-1) - 'a']++;
                        continue;
                    }

                }
                left = i;
                use = false;
                temp = new int[26];
                temp[text.charAt(left)-'a']++;
                last = text.charAt(left);

            }
        }
        return res;
    }
}
