/**
 * 1219. 黄金矿工
 * 回溯 dfs
 * 84ms 6.22%
 * 感觉和答案写的基本没差别 但是答案只用20ms 真不知道为啥
 */
public class class1219 {
    int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    int[][] grid;
    int res =0;
    public int getMaximumGold(int[][] grid) {
        this.grid = grid;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] > 0) {
                    DFS(i, j, 0);
                }
            }
        }
        return  res;
    }

    private void DFS(int i, int j, int sum) {
        sum += grid[i][j];
        res = Math.max(res,sum);
        int temp = grid[i][j];
        grid[i][j] = 0;
        for (int[] dir : dirs) {
            int ni = i + dir[0], nj = j + dir[1];
            if(ni<0 || ni>=grid.length || nj<0 || nj>=grid[0].length) continue;
            if (grid[ni][nj] > 0) {
                DFS(ni, nj, sum);
            }
        }
        grid[i][j]=temp;
    }
}
