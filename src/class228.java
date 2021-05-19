import java.util.ArrayList;
import java.util.List;

/*
        228. 汇总区间
        给定一个无重复元素的有序整数数组 nums 。

        简单
        8ms 40%
 */
public class class228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> list =new ArrayList<String>() ;
        if(nums.length == 0){
            return list;
        } else if( nums.length ==1 ){
            list.add(Integer.toString(nums[0]));
        }
        for( int i=1,index=0; i<nums.length; i++){
            if(nums[i]!=nums[i-1]+1){
                if(index==i-1){
                    list.add(Integer.toString(nums[i-1]));
                    index=i;
                } else{
                    String temp = Integer.toString(nums[index]) +"->" + Integer.toString(nums[i-1]);
                    list.add(temp);
                    index=i;
                }
            }
            if(i==nums.length-1){
                if(index==i){
                    list.add(Integer.toString(nums[i]));
                } else{
                    String temp = Integer.toString(nums[index]) +"->" + Integer.toString(nums[i]);
                    list.add(temp);
                }
            }
        }
        return list;
    }
}
