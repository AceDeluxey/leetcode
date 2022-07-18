package swordOffer;

/**
 * 剑指 Offer II 105. 岛屿的最大面积
 * dfs 289ms 6.3%
 */
public class swordII105 {
    int cnt=0;
    int [][]dir = {{1,0},{-1,0},{0,1},{0,-1}};
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]==1){
                    DFS(grid, i, j);
                    res = Math.max(res,cnt);
                    cnt =0;
                }
            }
        }
        return res;
    }
    private void DFS(int [][]grid, int i,int j){
        if((i>=grid.length || i<0 || j<0 || j>=grid[0].length) || grid[i][j]==0){
            return ;
        } else{
            cnt++;
            grid[i][j] =0;
        }

        System.out.print(i);
        System.out.print(j);
        for(int []temp :dir){
            int index1=i+temp[0];
            int index2=j+temp[1];
            DFS(grid,index1,index2);
        }
    }
}
