import java.util.Arrays;

/**
 * 913. 猫和老鼠
 * 有点问题 睡觉了 不知道哪里错
 */
public class class913 {
    private int DRAW = 0;
    private int MOUSE = 1;
    private int CAT = 2;

    public int catMouseGame(int[][] graph) {
        int n = graph.length;
        //猫和鼠在的坐标
        int visited[][][] = new int[n][n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(visited[i][j], -1);
            }
        }
        return dfs(graph, visited, 2, 1, 1);
    }

    private int dfs(int[][] graph, int[][][] visited, int cat, int mouse, int turns) {
        int n = graph.length;
        if (turns > n * (n - 1)) {
            return DRAW;
        }
        if (visited[cat][mouse][turns % 2] != -1) {
            return visited[cat][mouse][turns % 2];
        }
        if (cat == mouse) {
            return visited[cat][mouse][turns % 2] = CAT;
        }
        if (mouse == 0) {
            return visited[cat][mouse][turns % 2] = MOUSE;
        }
        //说明这一步是猫
        if (turns % 2 == 0) {
            //先假设是老鼠赢
            int res = MOUSE;
            for (int nextPos : graph[cat]) {
                if (nextPos != 0) {
                    int temp = dfs(graph, visited, nextPos, mouse, turns + 1);
                    if (temp == DRAW) {
                        res = DRAW;
                    }
                    if (temp == CAT) {
                        res = CAT;
                        break;
                    }
                }

            }

            visited[cat][mouse][turns % 2] = res;
            return res;
        } else {
            //老鼠的轮次，先假设是猫赢
            int res = CAT;
            for (int nextPos : graph[mouse]) {

                int temp = dfs(graph, visited, cat, nextPos, turns + 1);
                if (temp == DRAW) {
                    res = DRAW;
                }
                if (temp == MOUSE) {
                    res = MOUSE;
                    break;
                }
            }

            visited[cat][mouse][turns % 2] = res;
            return res;
        }
    }
}
