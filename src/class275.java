/**
    275. H 指数 II
    不用二分法还是不快啊
 */
public class class275 {
    public int hIndex(int[] citations) {
        int h=0;
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
