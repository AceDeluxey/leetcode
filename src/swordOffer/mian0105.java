package swordOffer;

/**
 * 面试题 01.05. 一次编辑
 * 分情况讨论，长度差大于2直接pass，然后算误差有没有超过1
 * O(m+n) 1ms 98%
 */
public class mian0105 {
    public boolean oneEditAway(String first, String second) {
        int len1 = first.length();
        int len2 = second.length();
        int cha = Math.abs(len1 - len2);
        boolean res;
        if (cha > 1) {
            return false;
        } else {
            res = check(len1, len2, first, second);
        }
        return res;
    }

    private boolean check(int len1, int len2, String first, String second) {
        int index1 = 0, index2 = 0;
        int cnt = 0;
        for (; index1 < len1 && index2 < len2; ) {
            if (cnt >= 2) {
                break;
            }
            if (first.charAt(index1) != second.charAt(index2)) {
                cnt++;
                if (len1 > len2) {
                    index1++;
                } else if (len1 < len2) {
                    index2++;
                } else{
                    index1++;
                    index2++;
                }
            } else {
                index1++;
                index2++;
            }
        }
        return cnt >= 2 ? false : true;
    }
}
