/**
 * 2315. 统计星号
 * 先写反了，后来又改回来了,反着想的
 * 2ms 59%
 */
public class class2315 {
    public int countAsterisks(String s) {
        char last = 'L';
        int cnt = 0;
        int res=0;
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '|') {
                if (last == 'L') {
                    last = '|';
                } else {
                    last = 'L';
                    res +=cnt;
                    cnt = 0 ;
                }
            } else if (c == '*') {
                total++;
                if (last == '|') {
                    cnt++;
                }
            }
        }
        return total-res;
    }
}
