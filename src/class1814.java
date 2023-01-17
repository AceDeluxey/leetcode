import java.util.HashMap;
import java.util.Map;

/**
 * 1814. 统计一个数组中好对子的数目
 * 等价为nums[i[ - rev(numi)
 *
 * 本来以为要On2的，没想到一次遍历可以
 * 比如有3 个 三次遍历分别是1+2+3，恰好就是3个两两配对，更多的也是以此类推
 * 29ms 90%
 */
public class class1814 {
    public int countNicePairs(int[] nums) {
        final int MOD = 1000000007;
        Map<Integer,Integer> map = new HashMap<>();
        int res =0 ;
        for(int i:nums){
            int temp = i,j=0;
            /**
             * 求反
             */
            while(temp>0){
                j = j*10+temp%10;
                temp /=10;
            }
            res = (res+map.getOrDefault(i-j,0))%MOD;
            map.put(i-j,map.getOrDefault(i-j,0)+1);
        }
        return res;
    }
}
