/**
 * 1326. 灌溉花园的最少水龙头数目
 * On
 * 贪心
 * https://leetcode.cn/problems/minimum-number-of-taps-to-open-to-water-a-garden/solution/python3javacgotypescript-yi-ti-yi-jie-ta-hwfe/
 * 看着这个写的
 * 其实看能看懂 原理
 * 但是你要我想我肯定想不出来
 * 有点抽象的  虽然能理解 但是总感觉差点什么
 * 3m's 88%
 */
public class class1326 {
    public int minTaps(int n, int[] ranges) {
        int last [] = new int[n+1];
        //记录每一个位置可能选取的能喷到最远的位置
        for (int i = 0; i < last.length; i++) {
            int l = Math.max(0,i-ranges[i]);
            int r = i+ranges[i];
            last[l] = Math.max(last[l], r);
        }
        int ans = 0, mx = 0, pre = 0;
        for (int i = 0; i < n; ++i) {
            mx = Math.max(mx, last[i]);
            if (mx <= i) {
                return -1;
            }
            if (pre == i) {
                ++ans;
                pre = mx;
            }
        }
        return ans;
    }
}
