/*
 * 198. 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

    给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。

    思路:
    * method1:
    *   ON2的动规，本来以为会很慢。
    *   相当于对每个点，把它前n-2个不相邻的点遍历了
    *   没想到 2ms 100% ; 35.9 M 36.42%
    *
    * method2:
    *   ON动规
    *   相较于Method1，不用遍历前N个，其实只和n-1和n-2的最大值有关
    * 0ms 100% ; 35.9M 41%
 */


public class class198 {
    public int rob(int[] nums) {
        //method2:
        if(nums.length == 1){
            return nums[0];
        }
        int dp[] = new int [nums.length];
        dp[0]=nums[0];
        if(nums[1]>=nums[0]){
            dp[1]=nums[1];
        } else{
            dp[1]=nums[0];
        }

        int result=Math.max(nums[0],nums[1]);
        if(nums.length == 2){
            return result;
        }
        for(int i=2;i<nums.length; i++){

            dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);

            if(dp[i]>result){
                result = dp[i];
            }
        }
        return result;


        //method1:
//        if(nums.length == 1){
//            return nums[0];
//        }
//        int dp[] = new int [nums.length];
//        dp[0]=nums[0];
//        dp[1]=nums[1];
//        int result=Math.max(nums[0],nums[1]);
//        if(nums.length == 2){
//            return result;
//        }
//        for(int i=2;i<nums.length; i++){
//            for(int j=0; j<i-1 ; j++){
//                dp[i]=Math.max(dp[i],nums[i]+dp[j]);
//            }
//            if(dp[i]>result){
//                result = dp[i];
//            }
//        }
//        return result;
    }
}
