/**
 * 88. 合并两个有序数组
 * 给你两个有序整数数组nums1 和 nums2，请你将 nums2 合并到nums1中，使 nums1 成为一个有序数组。
 * 初始化nums1 和 nums2 的元素数量分别为m 和 n 。你可以假设nums1 的空间大小等于m + n，这样它就有足够的空间保存来自 nums2 的元素。
 *
 * 思路：容易想到正向插入时，要不断移动num1，效率很低
 *      所以我们从末尾开始比较后插入nums1,
 *      index1指向Num1数的末尾，index2指向num2的末尾
 *      index3指向num1末尾
 *      因为是nums2插入到nums1中，所以必须遍历完nums2
 *      所以要判断index2和index3后将剩余的插入Nums1
 *
 *      0ms 100%; 38.2M 98%
 */

public class class88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1=m-1,index2=n-1;
        int index3=m+n-1;

        while(index1>=0 && index2>=0){
            if(nums2[index2]>=nums1[index1]){
                nums1[index3]=nums2[index2];
                index3--;
                index2--;
            } else{
                nums1[index3]=nums1[index1];
                index3--;
                index1--;
            }
        }

        while(index3>=0 && index2>=0){
            nums1[index3]=nums2[index3];
            index3--;
        }
    }
}
