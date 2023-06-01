import java.util.Arrays;

/**
 * 2517. 礼盒的最大甜蜜度
 * 执行用时：
 * 46 ms
 * , 在所有 Java 提交中击败了
 * 56.00%
 * 的用户
 * 内存消耗：
 * 53.2 MB
 * , 在所有 Java 提交中击败了
 * 21.72%
 * 的用户
 *
 * 又忘了，最大值的最小值，最小值的最大值多半是用二分法
 * 最大值的最小值
 * 最小值的最大值
 * 最大值的最小值
 * 二分法
 *
 * 然后重新看了以下二分法的边界条件
 * 如果是[left,right]
 * 当mid不满足条件时，因为，left和right都可以取，所以mid要+1和-1,不然mid还在区间里
 *
 * 当 [left，right)时.
 * mid不满足 left要+1,不然mid还在区间里
 * 但是right就不用-1，因为[left，right)，不减 mid也不会取到了
 *
 */
public class class2517 {
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int len = price.length;
        int left = 0,right = price[len-1];
        int ans =0;
        while(left<=right){
            int mid = left+(right-left)/2;
            //可以满足，说明应该提升甜蜜度
            if (check(price, k, mid)) {
                left = mid+1;
                ans = mid;
            } else{
                right = mid-1;
            }
        }
        //不能return mid, 因为可能超过最大值还在搜
        return ans;
    }
    private boolean check(int price[],int k ,int sweet ){
        /**
         * 关于为什么第一个是必须选的，因为第一个是最小的，
         * 如果选后面的
         * 比如 1 2 3 ，选 2 和 3 ，那1 肯定要比2 好，所以无论如何第一个都可能对应最大差值
         * 这是一种贪心的算法
         */

        int last =price[0];
        int init = last;
        k = k-1;
        for( int i =1;i<price.length;i++){
            if(price[i]-last>=sweet){

                last = price[i];
                k--;
            }
            if(k==0){
                return true;
            }
        }
        return false;
    }
}
