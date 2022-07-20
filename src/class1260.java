import java.util.ArrayList;
import java.util.List;

/**
 * 1260. 二维网格迁移
 * 展开 没写完
 */
public class class1260 {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int cnt =0 ;
        int nums = grid.length * grid[0].length;
        k = k%nums;
        for(int i=0;i< grid.length;i++){
            for (int j =0;j< grid[0].length;j++){
                if(cnt == k){
                    break;
                }
                cnt++;
            }
        }
        return new ArrayList<>();
    }
}
