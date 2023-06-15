

import java.util.ArrayList;
import java.util.List;

/**
 * 1177. 构建回文串检测
 * 8ms
 * 62
 * 学到了一种记录奇偶数的计数方式，用前缀记录对应位的异或数组
 * 这样就可以获取到区间内字母是双数还是单数
 *
 */
public class class1177 {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int pre [] = new int [s.length()+1];
        int len =s.length();
        for(int i =0;i<len ;i++){
            pre[i+1] = pre[i] ^ (1<<s.charAt(i)-'a');
        }
        List<Boolean> res = new ArrayList<>();
        for( int i =0 ; i <queries.length;i++){
            int l = queries[i][0], r = queries[i][1], k = queries[i][2];
            int bits = 0, x = pre[r + 1] ^ pre[l];
            while (x > 0) {
                x &= x - 1;
                bits++;
            }
            res.add(bits <= k * 2 + 1);


        }
        return res;
    }
}
