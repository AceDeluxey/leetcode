import java.util.Arrays;
import java.util.Comparator;

/**
 *  1893. 检查是否区域内所有整数都被覆盖
 *
 *  思路：先将ranges排序，成为比如[1,2],[2,4] ，排序完只用判断left是否落在每一个区间内就可以，如果满足，则left=range[1]+1
 *       因为如果left落在左边，比如说left是0，因为已经排过序了，最小的已经是1了，不可能找到更小的left了，所以Left在左边就不满足
 *       在右边，说明这个区间没有影响
 *       所以这样判断到最后，如果left>right，说明是每个值都有的
 *
 *       OlongnN 2ms 37%
 *
 */
public class class1893 {

    public boolean isCovered(int[][] ranges, int left, int right) {
        Arrays.sort(ranges,  new Comparator<int[]>() {
            public int compare(int[]a,int[]b){
                return a[0]-b[0];
            }
        });
        for (int i = 0; i < ranges.length; i++) {
            if (left <= ranges[i][1]) {
                if (left >= ranges[i][0]) {
                    left = ranges[i][1] + 1;
                }
            }
        }
        return left>right;
    }
}
