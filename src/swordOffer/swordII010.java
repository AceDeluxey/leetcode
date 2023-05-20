package swordOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer II 010. 和为 k 的子数组
 * 23ms 49
 * O1
 * 实际上就是用空间换时间
 * 本来对于每一个j，要去遍历他前面的所有i，计算有没有满足k的子数组
 * 但是这里相当于在一次遍历里把前面i对应大小对应个数存储到map里了
 * 所以是空间换时间
 * 不过还是值得看一下的
 *
 */
public class swordII010 {
    /**
     * k = sum[j] - sum[i-1],代表i到j的子数组
     * 那么对于每一个sum[j]，要找到有几个sum[j] - k
     * 也就是用map来存储sum[i-1]的个数
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int [] sum = new int[nums.length+1];
        Map<Integer,Integer> map = new HashMap<>();
        int res =0;
        map.put(0,1);
        for (int i =1;i<sum.length;i++){
            sum[i] = sum[i-1]+nums[i-1];
            res += map.getOrDefault(sum[i]-k,0);
            map.put(sum[i],map.getOrDefault(sum[i],0)+1);

        }
        return res;
    }
}
