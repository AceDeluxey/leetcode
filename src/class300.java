import com.sun.xml.internal.ws.encoding.MIMEPartStreamingDataHandler;

/**
 * 300. 最长递增子序列
 * dp:对于长度为n串，可以拆解为求n-1串的最长递增序列的子问题加一个元素的问题
 *  关键点在于并不是说得到n-1的值+1就行，还是要遍历前n-1的dp数组，对每个判断
 *  所以问题可以是前n-1直到前0字串加一个元素的问题
 *  时间 18%，空间31%，直接这样写是on2的时间复杂度，有很大提升空间
 *
 *
 *  TIPS：Arrays.fill可以填充数组
 */
import  java.util.Arrays;
public class class300 {
    public int lengthOfLIS(int[] nums) {
        int []dp=new int[nums.length];
        int result=1;
        if(nums.length==0){
            return 0;
        }
        Arrays.fill(dp,1);
        for(int i=1;i<nums.length; i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i]= Math.max(dp[i], dp[j]+1);
                    if(result<dp[i]){
                        result = dp[i];
                    }
                }
            }
        }
        return result;
    }
}
//class300 test= new class300();
//        int []a={10,9,2,5,3,7,101,18};
//        System.out.println(test.lengthOfLIS(a));