/**
 * 1785. 构成特定和需要添加的最少元素
 * 挺简单的
 * 就是这主意sum用long防止溢出就行了
 */
public class class1785 {
    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int res=0;
        if(sum==goal){
            return 0;
        } else if(sum<goal){
            long dif =goal-sum;
            if (dif % limit == 0) {
                res=(int)dif/limit;
            } else {
                res = (int)(dif)/limit +1;
            }
        } else{
            long dif =sum-goal;
            if (dif % limit == 0) {
                res=(int)dif/limit;
            } else {
                res =(int) (dif)/limit +1;
            }
        }
        return res;
    }
}
