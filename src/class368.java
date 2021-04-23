
/*
    368. 最大整除子集
        给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[j]) 都应当满足：
        answer[i] % answer[j] == 0 ，或
        answer[j] % answer[i] == 0
        如果存在多个有效解子集，返回其中任何一个均可。

   思路：二维DP，先对数组排序，方便遍历
        第一列dp代表这个数之前,可以组成的包含该数的最大整除子集的长度
        第二列代表这个数构成最大子集的情况下，上一个数的index
        On2遍历后，就可以得到最大值对应的坐标，倒着遍历回去就可以获得Array

     22ms 69.74%
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class class368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res =new ArrayList<Integer>();
        if(nums.length == 0){  //特判
            return res;
        }
        Arrays.sort(nums);  //先排序
        int dp[][]=new int[nums.length][2];
        dp[0][0]=1;   //其实初始情况下第一列都应该为1，但是初始化为1可以省略在循环中，见 47行
        for(int i=0;i<nums.length; i++){    //第二列都要初始化为-1，-1代表子集的结束，用于最后回溯循环时的标志位
            dp[i][1]=-1;
        }
        int max=1,maxIndex=0;
        for(int i=1;i<nums.length; i++){
            for(int j=0;j<i; j++){             //DP循环部分
                if(nums[i]%nums[j]==0){
                    if(dp[j][0]+1>dp[i][0]){
                        dp[i][0]=dp[j][0]+1;
                        dp[i][1]=j;
                        if(dp[i][0]>max){
                            max=dp[i][0];
                            maxIndex=i;        //找到最大的循环值
                        }
                    }
                }
            }
            if(dp[i][0]==0){        //这个数的循环完成后，如果数值还是0，说明是重新的一个子集，个数置为1
                dp[i][0]+=1;
            }
        }
        while(maxIndex!=-1){  //回溯，-1为结束回溯的判断
            res.add(nums[maxIndex] );
            maxIndex=dp[maxIndex][1];

        }
        return res;
    }
}
