import java.util.HashSet;
import java.util.Set;

/**
 * 2481. 分割圆的最少切割次数
 *
 * 执行用时：
 * 0 ms
 * , 在所有 Java 提交中击败了
 * 100.00%
 * 的用户
 * return  n%2==0?n/2:n;
 *
 */
public class class2481 {
    public int numberOfCuts(int n) {
        if (n <= 1) {
            return 0;
        }
//        int degree = 360 / n;
//        Set<Integer> set = new HashSet<>();
//        int start = 0;
//        for (int i = 0; i < n; i++) {
//            if (!set.contains(start - 180)) {
//                set.add(start);
//            }
//            start += degree;
//        }
//        return set.size();
        return  n%2==0?n/2:n;
    }
}
