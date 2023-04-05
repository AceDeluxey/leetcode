/**
 * 2427. 公因子的数目
 * 0ms 100%
 */
public class class2427 {
    public int commonFactors(int a, int b) {
        int c = gcd(a, b), ans = 0;
        for (int x = 1; x * x <= c; ++x) {
            if (c % x == 0) {
                ++ans;
                if (x * x != c) {
                    ++ans;
                }
            }
        }
        return ans;
    }

    public int gcd(int a, int b) {
        while (b != 0) {
            a %= b;
            a ^= b;
            b ^= a;
            a ^= b;
        }
        return a;
    }


}
