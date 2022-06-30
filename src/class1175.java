/**
 * 1175. 质数排列
 * 其实很简单 但就是要用long存
 *
 */
public class class1175 {
    int MOD = 1000000007;
    public int numPrimeArrangements(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (isPrime(i)) {
                sum++;
            }
        }
        int res = 1;
        int noPrime = n - sum;
        while (sum != 1) {
            res *= sum;
            res =res% MOD;
            sum--;
        }
        while (noPrime != 1) {
            res *= noPrime;
            res =res% MOD;
            noPrime--;
        }
        return res ;
    }

    private boolean isPrime(int i) {
        Boolean flag = true;
        for (int j = 2; j <= Math.sqrt(i); j++) {
            if (i % j == 0) {
                flag = false;
                break;
            }
        }
        if (i == 1) {
            flag = false;
        }
        return flag;
    }
}
