import java.util.ArrayList;
import java.util.Arrays;

/**
 *      1838. 最高频元素的频数
 *      元素的 频数 是该元素在一个数组中出现的次数。
 *      给你一个整数数组 nums 和一个整数 k 。在一步操作中，你可以选择 nums 的一个下标，并将该下标对应元素的值增加 1 。
 *
 *      思路1：On2,排序后，计算每个数可以凑出来的频数，超出时间限制
 *      思路2：可以优化，本质上是贪心算法,On1,还是比较巧妙的。
 *          从头开始扫描，比如【1，2，3】,扫描到2，先把1加到2，；扫描到3，有两个2，两个2都加到3；这样一次遍历去看有没有超过K
 *          如果超过，就优先减去左边使用的k，因为左边距离现在的i最远，去凑左边的不划算，所以贪心地释放掉最左边，看能不能用释放的在右边多凑几个
 *          31ms 98%
 *
 *      很巧妙的贪心
 */
public class class1838 {
    public int maxFrequency(int[] nums, int k) {
        //思路2：
        Arrays.sort(nums);
        //left表示左边的坐标，sum表示用的k的量
        int left=0,res=1,sum=0;
        for (int i = 1; i < nums.length; i++) {
            sum += (nums[i]-nums[i-1])*(i-left);
            //因为此时左边的都被加到nums[i]了，这时我们看看有没有更多，就必须要释放一些加过的。因为左边和nums[i]差的最多，所以根据贪心，应该先放弃左边的
            while(sum>k){
                sum -=nums[i]-nums[left];
                left ++;
            }
            //取最大值
            res=res<i-left+1? i-left+1:res;
        }
        return res;
        //思路1：
//        int res=Integer.MIN_VALUE;
//        Arrays.sort(nums);
//        for( int i=nums.length-1; i>=0 ;i--){
//            int sum=0;
//            int cnt=0;
//            for( int j=i;j>=0;j--){
//                sum+=nums[i]-nums[j];
//                if(sum<=k){
//                    cnt++;
//                } else{
//                     break;
//                }
//            }
//            if(res<cnt){
//                res=cnt;
//            }
//        }
//        return res;
    }
}
