/**
 * 2319. 判断矩阵是否是一个 X 矩阵
 * 1ms 99%
 */
public class class2319 {
    public boolean checkXMatrix(int[][] grid) {
        int len = grid.length;
        for( int i =0 ;  i < grid.length;i++){
            for (int j =0 ; j<grid.length;j++){
                if(i==j||i+j==len-1){
                    if(grid[i][j]==0){
                        return  false;
                    }
                } else{
                    if(grid[i][j]!=0){
                        return  false;
                    }
                }
            }
        }
        return true;
    }
}
