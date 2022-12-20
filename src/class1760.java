import java.util.Arrays;

/**
 * 1760. 袋子里最少数目的球
 * 求最大值的最小，最小值的最大，一般都是用二分
 * 这题里学会的首先是统计max,可以转化成stream直接求max()
 * 还有还是二分法的边界问题，什么时候用left<right,什么时候用Left<=right，不太懂
 * 这里找的就是最大值的最小值，
 * 对于每一个mid，就是对于每一个最终可能的结果，对于num个球，变成mid需要(num-1)/mid，就是0到mid一次都不用，mid到2*mid要一次，所以要num-1
    二分法的边界还是要搞清楚
 32ms 52%
 */
public class class1760 {
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1,right= Arrays.stream(nums).max().getAsInt();
        int res=0;
        while(left<=right){
            int mid = (right+left)/2;
            int sum =0 ;
            for( int num:nums){
                sum +=(num-1)/mid;
            }
            if(sum>maxOperations){
                left=mid+1;
            } else{
                res = mid;
                right =mid-1;
            }
        }
        return res;
    }
}
