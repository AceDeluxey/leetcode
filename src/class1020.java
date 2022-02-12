/**
 * 1020. 飞地的数量
 * 多源dfs 一次过
 * 我觉得多源不需要引入队列  变复杂了
 * 直接四个循环更简单
 *
 * 4md 79%
 *
 * Omn  DFS时间复杂度是mn 因为每个最多访问一次， 最后找1也是mn
 */
 class class1020 {
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    int grid[][];

    public int numEnclaves(int[][] grid) {
        this.grid = grid;
        //第一列
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 1) {
                DFS(i, 0);
            }
        }
        //最后一列
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][grid[0].length - 1] == 1) {
                DFS(i, grid[0].length - 1);
            }
        }
        // 第一行
        for (int i = 0; i < grid[0].length; i++) {
            if (grid[0][i] == 1) {
                DFS(0, i);
            }
        }
        //最后一行
        for (int i = 0; i < grid[0].length; i++) {
            if (grid[grid.length - 1][i] == 1) {
                DFS(grid.length - 1, i);
            }
        }

        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    res++;
                }
            }
        }
        return res;
    }

    private void DFS(int x, int y) {
        if (grid[x][y] == 1) {
            grid[x][y] = 0;
        }

        for (int[] dir : dirs) {
            int nx = x + dir[0], ny = y + dir[1];
            if (nx < 0 || nx > grid.length-1 || ny < 0 || ny > grid[0].length-1) continue;
            if (grid[nx][ny] == 1){
                DFS(nx,ny);
            }
        }
    }
}
