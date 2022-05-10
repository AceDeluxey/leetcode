/**
 * 942. 增减字符串匹配
    其实我也没完全搞懂，但是观察规律靠感觉可以做出来，就是大小交替
    2ms 85%
 */
public class class942 {
    public int[] diStringMatch(String s) {
        int len = s.length();
        int left = 0, right = len;
        int[] res = new int[len + 1];
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == 'I') {
                res[i] = left++;
            } else {
                res[i] = right--;
            }
        }
        res[len] = left;
        return res;
    }
}
