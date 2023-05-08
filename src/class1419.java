import java.util.HashMap;
import java.util.Map;

/**
 * 1419. 数青蛙
 * 模拟
 * 14ms 44.8
 * 是On 不知道为什么这么慢可能还是因为用了map吧？
 * 数据结构还是会造成时间复杂度上升 可能强行用if else写再程序里就好了吧
 */
public class class1419 {
    public static void main(String[] args) {
        class1419 test = new class1419();
        test.minNumberOfFrogs("");
    }
    public int minNumberOfFrogs(String croakOfFrogs) {
        int[] process = new int[5];
        Map<Character, Integer> map = new HashMap<>();
        map.put('c', 0);
        map.put('r', 1);
        map.put('o', 2);
        map.put('a', 3);
        map.put('k', 4);
        for (int i = 0; i < croakOfFrogs.length(); i++) {
            char temp = croakOfFrogs.charAt(i);
            int index = map.get(temp);
            if (process[index] == 0) {
                if(index==0){
                    process[(index + 1)%5] += 1;
                } else{
                    return -1;
                }

            } else {
                process[index] -= 1;
                process[(index + 1)%5] += 1;
            }

        }
        int res = 0;
        for (int i = 0; i < process.length; i++) {
            res += process[i];
        }
        return res==process[0]?res:-1;
    }
}
