import  java.util.HashSet;
public class sword03 {
    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> set=new HashSet<Integer>();
        for(int n: nums){
            if(!set.add(n)){
                return n;
            }
        }
        return 999;
    }
}
//main函数
//    sword03 test =new sword03();
//    int nums[]={2, 3, 1, 0, 2, 5, 3};
//        System.out.println(test.findRepeatNumber(nums));

//method2:可以用Bucket数组代替hashset，记录元素对应的下标，提高效率