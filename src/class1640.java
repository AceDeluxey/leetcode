import java.util.HashMap;
import java.util.Map;

/**
 * 1640. 能否连接形成数组
 * 题目中出现 每个数只出现一次的情况下 就要考虑又没哟可能用Map了
 * 存pieces每个temp的第一个数就可以了
 * 遍历两遍 O2N 1ms 79%
 */
public class class1640 {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < pieces.length; i++) {
            map.put(pieces[i][0], i);
        }
        int index = 0;
        while (index < arr.length) {
            int[] temp = new int[0];
            if (map.containsKey(arr[index])) {
                temp = pieces[map.get(arr[index])];

            } else{
                return false;
            }
            for (int i = 0; i < temp.length; i++) {
                if(temp[i]==arr[index]){
                    index++;
                } else{
                    return false;
                }

            }
        }
        return true;
    }
}
