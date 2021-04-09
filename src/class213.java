/*
    213. 打家劫舍 II
    你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
    同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
    给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。

    思路:
    method1: 我们从0开始遍历，前面都与普通打家劫舍一样，关键就是最后一个房子，要知道n-1和n-2个房子的最优解是否打了0号房子
            所以我写的话，前面一致，就是最后一栋房子做了特殊判断。将之前用过0房子的下标加入set
            过了60/70个用例，但是结果有错不知道怎么调了。因为给的用例有点长，很难找到哪里错了

    method2: 拆分成两个class198打家劫舍
             因为选了第一个就不能选最后一个，所以可以取前length-1个打一遍
             选了最后一个就不能选第一个，所以取后Length-1再打一遍
             取他们的最大值
             这样写要循环两遍，肯定没有Method1快，但是method1改不出来
               0ms 100%; 35.9M 36%
 */
import java.util.HashSet;
 class class213 {
    public int rob(int[] nums) {
        //method2:
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }

        int dp[]= new int [nums.length];
        //前length-1个的情况
        dp[0]=nums[0];
        if(nums[1]>=nums[0]){
            dp[1]=nums[1];
        } else{
            dp[1]=nums[0];
        }
        int i;
        for( i=2;i<nums.length-1; i++){
            dp[i]=Math.max(dp[i-2]+nums[i], dp[i-1] );
        }
        int result=dp[i-1];

        //后length-1个的情况
        dp[1]=nums[1];
        if(nums[2]>=nums[1]){
            dp[2]=nums[2];
        } else{
            dp[2]=nums[1];
        }
        for( i=3;i<nums.length; i++){
            dp[i]=Math.max(dp[i-2]+nums[i], dp[i-1] );
        }

        return Math.max(dp[i-1], result);
        //method1: 特殊判断最后一栋房子
//        if(nums.length == 1){
//            return nums[0];
//        }
//        if(nums.length == 1){
//            return 0;
//        }
//        int dp[]= new int [nums.length];
//        HashSet<Integer> set =new HashSet<Integer>();
//        set.add(0);
//        dp[0]=nums[0];
//        if(nums[1]>=nums[0]){
//            dp[1]=nums[1];
//        } else{
//            dp[1]=nums[0];
//            set.add(1);
//        }
//        int result=Math.max(nums[0],nums[1]);
//
//        for( int i=2 ; i<nums.length; i++){
//            if(i == nums.length -1 ){
//                dp[i]=nums[i];
//                if(set.contains(i-2)){
//                    dp[i]=Math.max(dp[i],dp[i-2]);
//                } else{
//                    dp[i]=Math.max(dp[i],dp[i-2]+nums[i]);
//                }
//
//                dp[i]=Math.max(dp[i],dp[i-1]);
//                if(dp[i]>result){
//                    result = dp[i];
//                }
//               break;
//            }
//            if(dp[i-2]+nums[i]>=dp[i-1]){
//                dp[i]=dp[i-2]+nums[i];
//                if(set.contains(i-2)){
//                    set.add(i);
//                }
//            } else{
//                dp[i]=dp[i-1];
//                if(set.contains(i-1)){
//                    set.add(i);
//                }
//            }
//            if(dp[i]>result){
//                result = dp[i];
//            }
//        }
//        return result;
    }
}
