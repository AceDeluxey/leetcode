import java.util.ArrayList;
import java.util.List;

/**
 * 1441. 用栈操作构建数组
 * 不明白到底考啥这个
 * 0ms 100
 */
public class class1441 {
    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<String>();
        int prev = 0;
        for (int number : target) {
            for (int i = 0; i < number - prev - 1; i++) {
                res.add("Push");
                res.add("Pop");
            }
            res.add("Push");
            prev = number;
        }
        return res;
    }


}
