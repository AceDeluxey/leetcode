/**
 * 258. 各位相加
 * 1ms 25%
 */
public class class258 {
    public int addDigits(int num) {
        while (num / 10 != 0) {
            num = add(num);
        }
        return num;
    }

    private int add(int num) {
        int res = 0;
        while (num != 0) {
            res += num % 10;
            num /= 10;
        }
        return res;
    }
}
