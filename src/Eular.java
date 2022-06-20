public class Eular {
    public static int calEular(int n) {
        int ans = n;
        for (int i = 2; i * i <= n; ++i) {
            if (n % i == 0) {
                System.out.println(i);
                ans = ans / i * (i - 1);
                while (n % i == 0)
                    n /= i;
            }
        }
        if (n > 1) ans = ans / n * (n - 1);
        System.out.println("");
        return ans;
    }

    /**
     * 输出质因数分解 和 欧拉函数值（质因数没有最后一个
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(calEular(36054));
    }
}
