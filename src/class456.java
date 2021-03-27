//456. 132 模式
public class class456 {
    public boolean find132pattern(int[] nums) {
        //思路在于遍历3和2，因为在顺序遍历3的时候，3的左边的最小值可以求出。
        //容易知道如果最小值不满足132，整个串也不会满足，所以左边不用查找，只用比较最小值
        int min=nums[0];
        for(int i=1;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(min<nums[j]&&nums[j]<nums[i]){
                    return true;
                }
            }
            if(nums[i]<min){
                min=nums[i];
            }
        }
        return false;

        //老是想着用指针，指针的特殊情况太多
//        int tail=-1,top=nums.length-1;
//        for(int i=0;i<nums.length;i++){
//            top=nums.length-1;
//            tail=-1;
//            int flag=0;
//            while(top!=i ){
//                if(  tail==-1 && nums[i]<nums[top]){
//                    tail=top-1;
//                    flag=1;
//                    if(nums[i]<nums[top] && nums[top]<nums[tail]){
//                        return true;
//                    }
//                } else if(flag==0){
//                    top--;
//                } else{
//                    tail--;
//                    if(tail == i){
//                        top--;
//                        tail=-1;
//                        continue;
//                    }
//                    if(nums[i]<nums[top] && nums[top]<nums[tail]){
//                        return true;
//                    }
//                }
//                if(top==i && top>i){
//                    top--;
//                    tail=-1;
//                }
//            }
//
//        }
//        return false;
    }
}
//class456 test =new class456();
//        int []nums = {-1,3,2,0};
//        System.out.println(test.find132pattern(nums));