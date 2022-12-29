import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2032. 至少在两个数组中出现的值
 * Hashmap，虽然简单 但是别说这些情况还是要想一下的
 * 3ms  55%
 */
public class class2032 {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for(int num:nums1){
            map.put(num,0);
        }
        for(int num:nums2){
            int n = map.getOrDefault(num,-1);
            // ==1说明有了，加进res，但是map要减去，不然重复算
            if(n==0){
                //==0说明nums1中有
                res.add(num);
                map.put(num,-2);
            } else if(n!=-2) {
                //等于1说明目前只有2 有
                map.put(num,1);
            }
        }
        for(int num:nums3){
            int n = map.getOrDefault(num,-1);
            if(n==0 || n==1){
                res.add(num);
                //防止重复
                map.put(num,-2);
            }
        }
        return res;
    }
}
