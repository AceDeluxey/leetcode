import java.util.Arrays;

/**
 * 274. H 指数
    思路：排序，排完序后怎么找到h是关键
        首先循环，如果某个数后面的个数大于这个数，则h是这个数，例如 3,5,6中的3
        然后是要考虑数组中没有h的可能，比如[100]，这时候就要看100这个数是不是大于长度1，大于则取max(h,len-i)
        这样写比解析直观很多。
    1ms 87.9%
 */
public class class274 {
    public int hIndex(int[] citations) {
        int h = 0;
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            //h的值在数组中的情况
            if (citations.length - i >= citations[i]) {
                h = citations[i];
            }
            //h的值不在数组中的情况，例如[100]
            if (citations.length - i < citations[i]) {
                h = Math.max(h, citations.length - i);
            }
        }
        return h;
    }
}
