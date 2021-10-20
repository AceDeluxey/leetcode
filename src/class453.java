/**
 453. 最小操作次数使数组元素相等

    思路：用了个很巧妙的思想，目的是为了把不一样高的抹平，那么给除了最高的加1，就等价于给最高的减一，达到的抹平效果是一样的
    On  1ms 100%
 */
public class class453 {
    public int minMoves(int[] nums) {
        int res =0 ;
        int min =  Integer.MAX_VALUE;
        for( int i =0 ; i < nums.length;i++){
            if(nums[i]<min){
                min = nums[i];
            }
        }
        for( int i =0 ; i < nums.length;i++){
            res += nums[i]-min;
        }
        return res;
    }
}
