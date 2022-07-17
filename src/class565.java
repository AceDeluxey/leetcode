/**
 * 565. 数组嵌套
 * 用负号标记遍历过的数组元素 On
 * 因为同一个set肯定一次就遍历完了
 * 4ms 79%
 */
public class class565 {
    public int arrayNesting(int[] nums) {
        int res = 0;
        for(int i =0 ; i < nums.length;i++){
            int cnt = 0 ;
            int index = i;
            while(nums[index]>=0){
                int temp = nums[index];
                nums[index] *= -1;
                cnt++;
                if(index == temp){
                    break;
                } else{
                    index = temp;
                }

            }
            res=Math.max(res,cnt);
        }
        return res;
    }
}
