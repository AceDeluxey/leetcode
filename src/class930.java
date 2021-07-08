import java.util.HashMap;

/**
 * 930. 和相同的二元子数组
 * 给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。
 * 子数组 是数组的一段连续部分。
 * <p>
 * 思路：直接用前缀和的话是On2,也跑的出来，1946ms 5%
 * 方法2是利用map<a,b>存储。键是从0开始的一段数组，其和为a，这样的数组有b个；其实本质上就是计算相同前缀和出现的次数
 * 16ms 75%
 */
public class class930 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        //On2暴力
//        int cnt = 0;
//        int len = nums.length;
//        for (int i = 0; i < len; i++) {
//            int sum = 0;
//            for (int k = i; k < len; k++) {
//                sum += nums[k];
//                if (sum == goal) {
//                    cnt++;
//                } else if (sum > goal) {
//                    break;
//                }
//            }
//        }
//        return cnt;
        //methos2:哈希存储左边的数组
        int cnt = 0;
        int len = nums.length;
        int[] sum = new int[len];
        //求前缀和
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                sum[0] = nums[0];
            } else {
                sum[i] = sum[i - 1] + nums[i];
            }
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        //前缀和为0时，说明left这块不用值，就直接有1种
        map.put(0, 1);
        for (int i = 0; i < len; i++) {
            // 看left有几种，sum[i]是总长，减去left就是一段字数组；
            //就比如说sum[i]是4，goal是2，那么就要找到前缀和是4-2=2的数组的个数，这个个数已经存到map里了
            int left = sum[i] - goal;
            cnt += map.getOrDefault(left, 0);
            map.put(sum[i], map.getOrDefault(sum[i], 0) + 1);
        }
        return cnt;
    }
}
