import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *1 630. 等差子数组
 */
public class class1630 {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res = new ArrayList<>();
        for( int i =0 ; i < l.length;i++){
            int left = l[i];
            int right = r[i];
            int[] ints = Arrays.copyOfRange(nums, left, right);
            res.add(check(ints));

        }
        return res;
    }

    /**
     * 就在选择排序时就可以判断 不用sort完
     * 虽然感觉时间复杂度都是onlogn
     * @param nums
     * @return
     */
    private boolean check(int[] nums){
        if( nums.length<=2){
            return true;
        }
        int surplus = -1;
        for ( int i =0 ;i<nums.length;i++){
            int index = i;
            for ( int j = i+1; j<nums.length;j++){
                if(nums[j]<nums[index]){
                    index=j;
                }
            }

            if(i<=1){
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                if(i==1){
                    surplus =nums[i]-nums[i-1];
                }
            } else{
                if(nums[i]-nums[i-1]!=surplus){
                    return false;
                } else {
                    surplus =nums[i]-nums[i-1];
                    int temp = nums[i];
                    nums[i] = nums[index];
                    nums[index] = temp;
                }
            }


        }
        return true;
    }
}
