import java.util.ArrayList;
import java.util.List;

/**
 * 442. 数组中重复的数据
 * 很巧妙很巧妙的做法，因为正负号对这个题没影响，直接用对应位置加正负号决定
 * 真巧妙
 * 5ms 82%
 */
public class class442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ;i<nums.length;i++){
            int num = Math.abs(nums[i]) ;
            if (nums[num-1]<0){
                list.add(num);
            } else{
                nums[num-1] *= -1;
            }
        }
        return list;
    }
}
