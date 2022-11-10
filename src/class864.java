import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * 864. 获取所有钥匙的最短路径
 * BfS + 位运算记忆化搜索
 *
 * 实在是没写出来，因为搜索的题太难调试了
 * 看代码感觉没问题，调试又调不来 实在没法稿
 * 说下我的判断重复走的条件 ， 就是当走到一个位置时它的status 小于map里存的，
 * map里存的时走step时，能拿到最多的钥匙，也就是最小部署，如果status小于map，说明不是最短路径 在重复走了
 * 所以要退出，找回路这一块卡了好久，但是de出来了
 * 至于最后结果实在是没de出来
 * 先交了
 * 它们的解法都是用数组记录下 到达xy一个状态的最小步数，没想清楚到底有没有关系
 */
public class class864 {
    public static void main(String[] args) {
        class864 test = new class864();
        String[] s = {"@abABFf"};
        test.shortestPathAllKeys(s);
    }

    public int shortestPathAllKeys(String[] grid) {
        Map<String,Integer> map = new HashMap<>();
        int row = grid.length;
        int col = grid[0].length();
        Queue<int[]> que = new ArrayDeque<>();
        int sx = 0, sy = 0;
        int keyCnt = 0;
        for (int i = 0; i < row; i++) {
            String temp = grid[i];
            for (int j = 0; j < col; j++) {
                char c = temp.charAt(j);
                if (c == '@') {
                    sx = i;
                    sy = j;
                } else if (c >= 'a' && c <= 'z') {
                    keyCnt++;
                }
            }
        }

        int mask = 0;
        for (int i = 0; i < keyCnt; i++) {
            mask = mask << 1;
            mask += 1;

        }
        int temp[] = {sx, sy, 0};
        que.offer(temp);
        int res = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                int[] a = que.poll();
                int x = a[0], y = a[1], status = a[2];
                String key = x +"+"+ y;

                String s = grid[x];
                char c = s.charAt(y);
                if (c >= 'a' && c <= 'z') {
                    status = status | 1 << (c - 'a');
                } else if (c >= 'A' && c <= 'Z') {
                    int b = 1 << (c - 'A');
                    //有钥匙
                    if ((status & b) == b) {

                    } else {
                        //没钥匙
                        continue;
                    }
                } else if (c == '#') {
                    continue;
                }
                if(map.containsKey(key)){
                    if(status <= map.get(key)){
                        continue;
                    } else if(status>map.get(key)){
                        //拿了其他钥匙回来也要更新
                        map.put(key,status);
                    }
                } else{
                    map.put(key,status);
                }

                if ((mask & status) == mask) {
                    return res;
                } else {
                    for (int[] dir : dirs) {
                        int nx = x + dir[0];
                        int ny = y + dir[1];
                        if (nx >= 0 && nx < row && ny >= 0 && ny < col) {
                            que.offer(new int[]{nx, ny, status});
                        }
                    }

                }
            }
            res++;

        }
        return -1;
    }
}
