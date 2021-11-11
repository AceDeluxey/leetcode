/**
 * 598. 范围求和 II
 *
    就是求左上角最小矩形的面积
    0ms 100%
 */
public class class598 {
    public int maxCount(int m, int n, int[][] ops) {
        int xMin = Integer.MAX_VALUE, yMin = Integer.MAX_VALUE;
        for (int[] temp : ops) {
            if (temp[0] < xMin) {
                xMin = temp[0];
            }
            if (temp[1] < yMin) {
                yMin = temp[1];
            }
        }
        return ops.length > 0 ? (xMin ) * (yMin ) : m * n;
    }
}
