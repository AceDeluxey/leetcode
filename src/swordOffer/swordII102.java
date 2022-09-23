package swordOffer;

/**
 * 剑指 Offer II 102. 加减的目标值
 *就是暴力解法 dfs遍历所有情况，
 * 但是复杂度是2的n次方 500ms 20%
 *
 */
public class swordII102 {
    int cnt =0 ;
    public int findTargetSumWays(int[] nums, int target) {
        dfs(nums, 0, 0,target);
        return cnt;
    }

    private  void dfs(int []nums, int sum, int i,int target){
        if(i==nums.length){
            if(sum==target){
                cnt ++;
            }
            return ;
        }
        dfs(nums,sum+nums[i],i+1,target);
        dfs(nums,sum-nums[i],i+1,target);
    }
}
