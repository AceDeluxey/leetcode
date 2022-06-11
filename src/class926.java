/**
926. 将字符串翻转到单调递增

 17ms 38% 前缀和
 */
public class class926 {
    public int minFlipsMonoIncr(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                sum += 1;
            }
        }
        int oneNum = 0;
        int res = s.length() - sum;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                oneNum++;
            }
            res= Math.min(res,oneNum+(s.length()-(i+1)-(sum-oneNum)));
        }

        return res;
    }
}
