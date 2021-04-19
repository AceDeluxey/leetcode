/*
    27. 移除元素
    移除Nums数组中的val，不需要担心多余空间
    要求空间复杂度为O(1)

    思路：双指针，遍历时记录上一次置为的位置
 */
public class class27 {
    public int removeElement(int[] nums, int val) {
        int index=0;
        int cnt=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] != val){
                nums[index++]=nums[i];
                cnt++;
            }
        }
        return cnt;
    }
}
