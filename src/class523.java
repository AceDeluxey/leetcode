import java.util.HashMap;
import  java.util.HashMap;

/*
    523. 连续的子数组和
    给你一个整数数组 nums 和一个整数 k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
        子数组大小 至少为 2 ，且
        子数组元素总和为 k 的倍数。
    如果存在，返回 true ；否则，返回 false 。

    思路：前缀和+HashMap
        sum[i]是0到i的前缀和，将sum[i]%k,i put进map，
        如果有j=i+1,使得sum[j]%k==sum[i]%k,那么说明i到j的数组的和是k的倍数

     17ms 79.5%
 */
public class class523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap();
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int mod=sum%k;
            if(mod == 0 && i>=1){
                return true;
            }
            if(map.containsKey(mod)){
                if((i-map.get(mod))>1){
                    return true;
                }
            } else{
                map.put(mod,i);
            }
        }
        return false;
    }
}
