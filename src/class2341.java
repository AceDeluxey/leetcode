import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2341. 数组能形成多少数对
 * 1ms 54%
 * 我这方法还是有点抽象的
 */
public class class2341 {
    public int[] numberOfPairs(int[] nums) {
        if (nums.length == 1) {
            return new int[]{0, 1};
        }
        Arrays.sort(nums);
//        List<Integer> list = new ArrayList<>();
        int sum = 0;
        int sum2 = 0;
        int i = 1;
        for (; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                sum += 1;
                 i+=1;
            } else {
                sum2+=1;
            }
        }
        if(i==nums.length){
            sum2+=1;
        }
        return new int []{sum,sum2};
    }
}
