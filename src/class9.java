/**
    9. 回文数
    给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false

    思路：首先负数必定不是回文排除
         然后将int转换成string,判断string前和后一不一样，O(n/2)
        9ms 67%
 */

public class class9 {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else {
            String s = Integer.toString(x);
            for (int i = 0; i < s.length() / 2; i++) {
                if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                    return false;
                }
            }
        }
        return true;
    }
}
