/*
    1262. 可被三整除的最大和
    给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。
 */
public class class1262 {
//    2023 06 19 重写
    public int maxSumDivThree(int[] nums){
        int []remainder = {0,0,0};
        for(int i = 0; i < nums.length; i++){
            int a,b,c;
            a = remainder[0] + nums[i];
            b = remainder[1] + nums[i];
            c = remainder[2] + nums[i];
            remainder[a%3] = Math.max(remainder[a%3], a);
            remainder[b%3] = Math.max(remainder[b%3], b);
            remainder[c%3] = Math.max(remainder[c%3], c);
        }
        return remainder[0];


//        还是写不对，佛了
//        int []dp = {0,0,0};
//        for (int num : nums) {
//            if(num%3==0){
//                dp[0]+=num;
//            } else if(num%3==1){
//                dp[1] = Math.max(dp[0]+num,num);
//                if((dp[0]+num)%3==0){
//                    dp[0] = Math.max(dp[0],dp[2]+num);
//                }
//
//            } else{
//                dp[2] = Math.max(dp[0]+num,num);
//                if((dp[0]+num%3)==0){
//                    dp[0] = Math.max(dp[0],dp[0]+num);
//                }
//
//            }
//        }
//        return  dp[0];
    }
//    public int maxSumDivThree(int[] nums) {
//        int result=0;
//        int stack1[]=new int [nums.length];
//        int top1=0;
//        int stack2[]=new int [nums.length];
//        int top2=0;
//        for(int i=0;i<nums.length; i++){
//            if (nums[i] % 3 == 0) {
//                result+=nums[i];
//            } else if(nums[i] % 3 == 1){
//                    stack1[top1++]=nums[i];
//            } else{
//                stack2[top2++]=nums[i];
//            }
//        }
//        for(int i=0;i<top1-1;i++){
//            for( int j=0;j<top1-1-i;j++){
//                if(stack1[j]>stack1[j+1]){
//                    stack1[j]=stack1[j]+stack1[j+1];
//                    stack1[j+1]=stack1[j]-stack1[j+1];
//                    stack1[j]=stack1[j]-stack1[j+1];
//                }
//            }
//        }
//        for(int i=0;i<top2-1;i++){
//            for( int j=0;j<top2-1-i;j++){
//                if(stack2[j]>stack2[j+1]){
//                    stack2[j]=stack2[j]+stack2[j+1];
//                    stack2[j+1]=stack2[j]-stack2[j+1];
//                    stack2[j]=stack2[j]-stack2[j+1];
//                }
//            }
//        }
//        int index=Math.min(top1, top2);
//        if(index!=0){
//            for(int i=index;i>0;i--){
//                result += stack1[--top1]+stack2[--top2];
//            }
//        }
//
//        return result;
//    }
}
//class1262 test= new class1262();
//        int []a= {1,2,3,4,4};
//        System.out.println(test.maxSumDivThree(a));