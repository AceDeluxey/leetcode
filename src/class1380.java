import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *  1380. 矩阵中的幸运数
 *  3ms 55%
 */
public class class1380 {
    public List<Integer> luckyNumbers(int[][] matrix) {
        //每行的最小值
        int row_min[] = new int[matrix.length];
        //每列最大值
        int col_max[] = new int[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            row_min[i] = Integer.MAX_VALUE;
            for (int j = 0; j < matrix[0].length; j++) {
                row_min[i] = Math.min(row_min[i], matrix[i][j]);
                col_max[j] = Math.max(col_max[j], matrix[i][j]);
            }
        }

        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int a = matrix[i][j];
                if (a == row_min[i] && a == col_max[j]) {
                    res.add(a);
                }
            }
        }

        return res;
    }
}
