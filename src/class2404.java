/**
 * 2404. 出现最频繁的偶数元素
 * 7ms 95%
 * 还是用数组快一些
 */
public class class2404 {
    public int mostFrequentEven(int[] nums) {

        int cnt[] = new int[100001];
        int max = 0;
        int res = -1;
        for (int num : nums) {
            if((num&1) ==1){
                continue;
            }
            int temp = ++cnt[num];
            if (temp > max || (temp==max && res>num)) {
                res = num;
                max = temp;
            }
        }
        return res;
    }
}
