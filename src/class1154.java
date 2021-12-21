import java.util.HashMap;
import java.util.Map;

/**
 * 1154. 一年中的第几天
 *
 * 思路：简单，处理字符串，判断闰年就可以了
 *
 * 13ms 51%
 */
public class class1154 {
    public int dayOfYear(String date) {
        int res = 0;
        String[] d = date.split("-");
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 31);
        map.put(3, 31);
        map.put(5, 31);
        map.put(7, 31);
        map.put(8, 31);
        map.put(10, 31);
        map.put(12, 31);
        boolean isRun = false;
        int year = Integer.parseInt(d[0]);
        int month = Integer.parseInt(d[1]);
        int day = Integer.parseInt(d[2]);
        if (year % 4 == 0 && year % 100 != 0) {
            isRun = true;
        } else if (year % 400 == 0) {
            isRun = true;
        }
        for (int i = 1; i < month; i++) {
            if (i != 2) {
                res += map.containsKey(i) ? 31 : 30;
            } else {
                res +=isRun?29:28;
            }
        }
        res += day;
        return res;
    }
}
