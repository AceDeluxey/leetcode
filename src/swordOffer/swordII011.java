package swordOffer;

import java.util.HashMap;

/**
 * 剑指 Offer II 011. 0 和 1 个数相同的子数组
 * 确实01看一眼就能看出来是前缀和，但是没想到0要用-1来代替
 * 确实用-1代替，如果有两个index的前缀和相等，那就说明中间部分0和1的个数相同
 * 而用0 1 确实不行，还要计算，还要遍历，因为是递增的
 *
 * 而且用map只用记录第一次出现的，因为求的是最长的长度
 *
 * 执行用时：
 * 23 ms
 * , 在所有 Java 提交中击败了
 * 54.60%  On
 * 的用户
 * 值得看
 */
public class swordII011 {
    public int findMaxLength(int[] nums) {
        int presum =0 ;
//        存presum和对应第一次出现的下标
        HashMap<Integer,Integer> map = new HashMap<>();

        //第一个数字之前也是presum为0
        map.put(0,-1);
        int res = 0 ;
        for( int i =0 ; i < nums.length;i++){
           if(nums[i]==0){
               presum--;
           } else{
               presum++;
           }
           if(map.containsKey(presum)){
               res = Math.max(i-map.get(presum),res);
           } else{
               map.put(presum,i);
           }
        }
        return res;

    }
}
