/**
 * 807. 保持城市天际线
 *
 * 思路：贪心  循环找出每行每列的最大值， 和两个最大值中小的那个的差就是增加值
 *
 * 1ms 86%
 */
public class class807 {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int [] rowsMax = new int [grid.length];
        int [] colsMax = new int [grid[0].length];
        //逐行扫描，计算每行的最大值
        for(int i=0; i < grid.length; i++){
            for( int j = 0 ; j <grid[0].length;j++){
                rowsMax[i] = Math.max(rowsMax[i],grid[i][j]);
                colsMax[j] = Math.max(colsMax[j],grid[i][j]);
            }
        }

        int sum = 0;
        //获取每个位置的增高量
        for( int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++) {
                int sur = Math.min(rowsMax[i],colsMax[j] )-grid[i][j];
                sum += (sur)>0?sur : 0;
            }
        }
        return  sum;
    }
}
