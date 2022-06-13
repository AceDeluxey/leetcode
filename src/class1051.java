import java.util.Arrays;

/**
 * 1051. 高度检查器
 * 就是clone一个排序就好了
 * 0nlogn 1ms 68%
 */
public class class1051 {
    public int heightChecker(int[] heights) {
        int before[] = heights.clone();
        Arrays.sort(heights);
        int res = 0 ;
        for(int i = 0; i < heights.length; i++){
            if (before[i] != heights[i]) {
                res++;
            }
        }
        return res;
    }
}
