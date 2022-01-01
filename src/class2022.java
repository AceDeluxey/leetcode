/**
 * 2022. 将一维数组转变成二维数组
 *
 * 思路:简单
 * 3ms 99%
 */
public class class2022 {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int res[][] = {};
        if (original.length != m * n) {
            return res;
        }

        res = new int[m][n];
        int index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = original[index++];
            }
        }
        return res;
    }
}
