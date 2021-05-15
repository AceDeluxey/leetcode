import java.util.Arrays;

/*
    75. 颜色分类
    给定一个包含红色、白色和蓝色，一共n 个元素的数组，原地对它们进行排序，
    使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列
    此题中，我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。

    思路：相当于只有0,1,2三个数的排序，所以可以一次遍历算出0 1的数量
        然后从头到尾插入一次就行了

        0ms 100%

 */
public class class75 {
    public void sortColors(int[] nums) {

        int numOf0=0,numof1=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0){
                numOf0++;
            } else if(nums[i]==1){
                numof1++;
            }
        }
        Arrays.fill(nums,2);
        int i=0;
        for(;i<numOf0;i++){
            nums[i] = 0;
        }
        for(;i<numOf0+numof1;i++){
            nums[i] = 1;
        }
    }
}
