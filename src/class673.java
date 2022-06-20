import java.util.Arrays;
/*
    673. 最长递增子序列的个数
    给定一个未排序的整数数组，找到最长递增子序列的个数。
 */
//class673 test=new class673();
//        int []a={1,2,4,3,5,4,7,2};
//        test.findNumberOfLIS(a);
//此时有问题，它会遍历1 2 3 4 7 ； 1 2 3 5 7 和 1 2 4 5 7中的两种
public class class673 {
    public int findNumberOfLIS(int[] nums) {
        if(nums.length==0 ){
            return 0;
        }
        int []dp=new int [nums.length];
        Arrays.fill(dp, 1);
        int result=1;
        int cnt=1;
//        int max_cnt=0;
        for(int i=1;i<nums.length; i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    if(dp[j]+1>=dp[i]){
                        dp[i]=dp[j]+1;
                        if(result<dp[i]){
                            result = dp[i];
                            cnt=1;
                        } else if (result == dp[i]) {
                            cnt++;
                        }
                    }
                }
            }
            if(result==1){
                cnt++;
            }
        }
        return cnt;
    }
}
