/**
 * 1254. 统计封闭岛屿的数目
 * 真不知道哪里有错
 *
 * 这种题真的不知道咋debug 因为有递归
 *
 * 原理很简单
 * 就是用DFS，遇到0就去搜索，把0置为1
 * 然后判断封闭？边界边的不封闭，也就是搜的过程中，如果超出边界就是false,如果没有超出，就是封闭
 * 看了官方解答的dfs,和我这个想法一模一样
 * 不知道哪里写错了
 *
 */
public class cLass1254 {
    public int closedIsland(int[][] grid) {
        int res =0 ;
        for (int i =0 ;i< grid.length;i++){
            for (int j =0 ;j< grid[0].length;j++){
                if(grid[i][j]==0){
                    if(DFS(grid,i,j)){
                        res ++;
                    }
                }
            }
        }
        return res;
    }
    private boolean DFS(int [][]grid , int i ,int j ){
        boolean flag = true;
        if(i<0 ||i>= grid.length||j<0||j>=grid[0].length){
            return false;
        }
        if(grid[i][j]==0){
            grid[i][j]=1;
        } else{
            return  true;
        }
        int dirs [] [] = {{1,0},{-1,0},{0,1},{0,-1}};
        for (int[] dir : dirs) {
            int ni = i+dir[0];
            int nj = j+dir[1];
            flag = flag && DFS(grid,ni,nj);
        }
        return flag;
    }
}
