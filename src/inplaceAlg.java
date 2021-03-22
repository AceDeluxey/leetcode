//原地算法用于不使用额外空间的，有序数组去重,实质上是双指针
public class inplaceAlg {
    public int removeDuplicates(int[] nums) {
        int i=0;
      for( int num : nums){
            if(i==0 || nums[i-1]<num){
                nums[i]=num;
                i++;
            }
      }
        for(int n=0;n<i;n++){
            System.out.println(nums[n]);
        }
      return i;
    }
//    public static void main(String[] args) {
//        inplaceAlg test =new inplaceAlg();
//        int nums[]={0,0,1,1,2,3,4};
//        test.removeDuplicates(nums);
//        System.out.println(nums);
//    }

}
