import java.util.LinkedList;
import java.util.List;

/**
 * 728. 自除数
 */
public class class728 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new LinkedList<>();
        for (int i = left; i <= right; i++) {
            if (isDN(i)) {
                res.add(i);
            }
        }
        return res;
    }

    private boolean isDN(int num) {
        int temp = num;
        while (temp > 0) {
            int remainder = temp % 10;
            if (remainder ==0 || num % remainder != 0) {
                return false;
            }
            temp = temp / 10;
        }
        return true;
    }
}
