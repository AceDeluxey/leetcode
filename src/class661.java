/**
 * 661. 图片平滑器
 * 其实就是卷积
 * 9ms 19.82%
 */
public class class661 {
    public int[][] imageSmoother(int[][] img) {
        int[][] res = new int[img.length][img[0].length];
        int[][] dirs = {{0, 0}, {0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img[i].length; j++) {
                double sum = 0;
                int cnt = 0;
                for (int[] dir : dirs) {
                    int ni = i + dir[0];
                    int nj = j + dir[1];
                    if (ni < 0 || ni >= img.length || nj < 0 || nj >= img[0].length) {
                        continue;
                    }
                    sum += img[ni][nj];
                    cnt++;
                }
                res[i][j] = (int) Math.floor(sum / cnt);
            }
        }
        return res;
    }
}
