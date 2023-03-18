/**
 * 1616. 分割两个字符串得到回文串
 * 其实算贪心，先求a的头和b的尾最长符合的，然后剩下的那段判断是不是回文就好了
 * 然后要判断a b可以颠倒
 * 3ms 99%
 */
public class class1616 {
    public boolean checkPalindromeFormation(String a, String b) {
        return check(a, b) || check(b, a);
    }

    // 如果 a_prefix + b_suffix 可以构成回文串则返回 true，否则返回 false
    private boolean check(String a, String b) {
        int i = 0, j = a.length() - 1; // 相向双指针
        while (i < j && a.charAt(i) == b.charAt(j)) { // 前后缀尽量匹配
            ++i;
            --j;
        }
        return isPalindrome(a, i, j) || isPalindrome(b, i, j);
    }

    // 如果从 s[i] 到 s[j] 是回文串则返回 true，否则返回 false
    private boolean isPalindrome(String s, int i, int j) {
        while (i < j && s.charAt(i) == s.charAt(j)) {
            ++i;
            --j;
        }
        return i >= j;
    }

//    public boolean checkPalindromeFormation(String a, String b) {
//        int len = a.length();
//        int left = 0, right = len-1;
//        while(left < right){
//            if(a.charAt(left)!= b.charAt(right) && a.charAt(right)!= b.charAt(left) ){
//                return  false;
//            } else{
//                left++;
//                right--;
//            }
//        }
//        return true;
//    }
}
