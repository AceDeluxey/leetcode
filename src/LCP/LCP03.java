package LCP;

import java.util.HashMap;
import java.util.HashSet;

/**
 * LCP 03. 机器人大冒险
 * 就是嗯暴力
 * 但是红红火火恍恍惚惚 怎么时间复杂度这么高
 * 1859ms 5.2%
 *
 * 看了解答懂了，应该用求余的方式求解，在一个循环里x和y走的长度是一致的，那么只要用第一个循环内各点的位置加上步长就可以求出来了
 * 而不用每一步都遍历到
 *
 * 有点脑筋急转弯
 */
public class LCP03 {
    public boolean robot(String command, int[][] obstacles, int x, int y) {
        int index = 0;
        int nx = 0, ny = 0;
        HashMap<Integer, HashSet> map = new HashMap<>();
        for (int[] obstacle : obstacles) {
            int tx = obstacle[0];
            int ty = obstacle[1];
            HashSet set = map.getOrDefault(tx, new HashSet());
            set.add(ty);
            map.put(tx, set);
        }
        while (true) {
            if (command.charAt(index) == 'U') {
                ny += 1;
            } else {
                nx += 1;
            }
            if (nx == x && ny == y) {
                return true;
            }
            //已经超出去了
            if (ny > y || nx > x) {
                return false;
            } else if (map.getOrDefault(nx, new HashSet()).contains(ny)) {
                //撞到障碍物
                return false;
            }
            index = (index + 1) % command.length();
        }
    }
}
