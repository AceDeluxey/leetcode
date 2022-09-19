import java.util.Arrays;
import java.util.Comparator;

/**
 * 1636. 按照频率将数组升序排序
 *
 * map + 排序 + 遍历
 */
public class class1636 {
    public int[] frequencySort(int[] nums) {
        int[][] map = new int[201][2];
        for (int i = -100; i < 101; i++) {
            map[i + 100][1] = i;
        }
        for (int i = 0; i < nums.length; i++) {
            map[nums[i] + 100][0]++;

        }
        Arrays.sort(map, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
            }
        });
        int res[] = new int[nums.length];
        int index = 0;
        for (int i = 0; i < map.length; i++) {
            while (map[i][0] > 0) {
                res[index++] = map[i][1];
                map[i][0]--;
            }
        }
        return res;
    }
}
