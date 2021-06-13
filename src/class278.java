/**
 *  278. 第一个错误的版本
 *      二分法找分割点，不想做
 *
 *     暴力会超时
 *     二分 16ms 99%
 */
public class class278 {
    boolean isBadVersion(int version){
        return true;
    }
    public int firstBadVersion(int n) {
        int lo = 1;
        int hi = n;

        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (isBadVersion(mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return hi;
//        for(int i=n;i>=1;i--)
//            if(!isBadVersion(i-1)&&isBadVersion(i)) return i;
//        return 0;
    }
}
