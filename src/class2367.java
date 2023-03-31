import java.util.HashSet;
import java.util.Set;

/**
 * 2367. 算术三元组的数目
 * set
 * 2ms 43
 * 虽然是ON
 */
public class class2367 {
    public int arithmeticTriplets(int[] nums, int diff) {
        Set<Integer> set = new HashSet<Integer>();
        for (int x : nums) {
            set.add(x);
        }
        int ans = 0;
        for (int x : nums) {
            if (set.contains(x + diff) && set.contains(x + 2 * diff)) {
                ans++;
            }
        }
        return ans;

    }
}
