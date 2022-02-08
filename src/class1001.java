import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 1001. 网格照明
 * 非常巧妙的一题
 * 网格太大难以遍历，那就存lamp数量，和点亮lamp后亮的行 列 对角线
 * 对角线存储用的是 x+y = k， 同一对角线的k相同，然后用map存
 * 熄灭就从set移除，map移除
 *
 */
public class class1001 {
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        //遍历周围8个
        int[][] dirs = new int[][]{{0, 0}, {0, 1}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {1, 0}, {1, 1}};
        HashMap<Integer, Integer> rows = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> cols = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> diag = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> diag2 = new HashMap<Integer, Integer>();
        Set<String> points = new HashSet<String>();
        for (int[] lamp : lamps) {
            int x = lamp[0], y = y = lamp[1];
            //点亮的灯存set
            String point = x + "+" + y;
            if (points.contains(point)) {
                continue;
            } else {
                points.add(point);
            }
            //代表这一行、列、对角线有几个灯亮，对应的行列对角线也都亮
            rows.put(x, rows.getOrDefault(x, 0) + 1);
            cols.put(y, cols.getOrDefault(y, 0) + 1);
            diag.put(x + y, diag.getOrDefault(x + y, 0) + 1);
            diag2.put(x - y, diag2.getOrDefault(x - y, 0) + 1);
        }

        int res[] = new int[queries.length];
        int index = 0;
        for (int[] query : queries) {
            int x = query[0], y = query[1];
            // 存了行列对角线中的一个或多个，代表这个query是亮的
            if (rows.containsKey(x) || cols.containsKey(y) || diag.containsKey(x + y) || diag2.containsKey(x - y)) {
                res[index++] = 1;
            }
            for (int[] dir : dirs) {
                int x1 = x + dir[0], y1 = y + dir[1];
                //查到已经开的灯，关掉
                boolean isRemove = points.remove(x1 + "+" + y1);
                if ( isRemove ){
                    if(rows.get(x1).intValue()<=1){
                        rows.remove(x1);
                    } else{
                        rows.put(x1, rows.getOrDefault(x1, 0) - 1);
                    }

                    if(cols.get(y1).intValue()<=1){
                        cols.remove(y1);
                    } else{
                        cols.put(y1, cols.getOrDefault(y1, 0) - 1);
                    }

                    if(diag.get(x1 + y1).intValue()<=1){
                        diag.remove(x1 + y1);
                    } else{
                        diag.put(x1 + y1, diag.getOrDefault(x1 + y1, 0) - 1);
                    }

                    if(diag2.get(x1 - y1).intValue()<=1){
                        diag2.remove(x1 - y1);
                    } else{
                        diag2.put(x1 - y1, diag2.getOrDefault(x1- y1, 0) - 1);
                    }

                }
            }

        }
        return res;
    }
}
