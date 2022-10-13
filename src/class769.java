/**
 * 769. 最多能完成排序的块
 * 纯靠想的题，因为是0 1 2 3.。。这样
 * 所以如果到i位能分成块的话，比如0 1 2 3，无论如何都要包含这几个数字，也就是说当遍历到i=3时，最大值是3
 * 想要举反例的话 比如 0 1 2 4，到最大值4 i只到3 说明 4 前面有一位在后面 这样的话这块就不对了
 * 还是要点巧思
 * 从 0 1 2 3 .。n-1， 可以分n块 或许可以看出来
 * 但是也不是百分之百
 * 0ms 100
 */
public class class769 {
    public int maxChunksToSorted(int[] arr) {
        int res = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (max == i) {
                res++;
            }
        }
        return res;
    }
}
