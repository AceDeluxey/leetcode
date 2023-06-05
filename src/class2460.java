/**
 * 2460. 对数组执行操作
 * 佛
 */
public class class2460 {
    public static void main(String[] args) {
        class2460 test  = new class2460();
        int a []= {0,1};
        test.applyOperations(a);
    }
    public int[] applyOperations(int[] nums) {
        int cnt = nums[0]==0?0:1 ;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i-1]){
                nums[i-1] = 2* nums[i-1];
                nums[i] = 0;
            }
            if(nums[i]!=0){
                cnt++;
            }
        }
        int left =0;

        int [] res =new int[nums.length];
        for (int i = 0; i < nums.length; i++) {

            if(nums[i]!=0){
                res[left++]=nums[i];
            }

        }

        return res;
    }
}
