import java.util.HashMap;
import java.util.Map;

/*
    447. 回旋镖的数量
        给定平面上n 对 互不相同 的点points ，其中 points[i] = [xi, yi] 。回旋镖 是由点(i, j, k) 表示的元组 ，其中i和之间的距离和之间的距离相等（需要考虑元组的顺序）。

       思路：暴力搜索+hashmap+组合数

       163ms  33%; 复杂度On2

 */
public class class447 {
    public int numberOfBoomerangs(int[][] points) {
        int result=0;

        //以每个点为顶点找回旋镖
        for (int[] point : points) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int[] q : points) {
                int distance = (int) (Math.pow((point[0] - q[0]), 2) + Math.pow((point[1] - q[1]), 2));
                map.put(distance, map.getOrDefault(distance, 0) + 1);
            }

            //计算每个点为顶点的回旋镖，因为跟顺序有关。所以是An2,排列数

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                result += entry.getValue()*(entry.getValue()-1);
            }

        }

        return result;
    }
}
