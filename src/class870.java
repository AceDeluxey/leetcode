import java.util.Arrays;
import java.util.Comparator;

/**
    870. 优势洗牌
    给定两个大小相等的数组 A 和 B，A 相对于 B 的优势可以用满足 A[i] > B[i] 的索引 i 的数目来描述。
    返回 A 的任意排列，使其相对于 B 的优势最大化。

    思路：田忌赛马，用我的最小的去对别人最大的。也就是贪心
        将nums2扩充一列pos，然后排序num1,num2；
        从num2末尾向前匹配，如果我的位置比不过，就用最小的匹配，
        这样是最优的，因为这样等于说用最差的去匹配一个必输的情况，而原来最小的位置我对应的反而会变大，所以最优
        然后剩下就是双指针

    复杂度是排序复杂度Onlogn 35ms 92%

 */
public class class870 {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int len = nums1.length;
        int [][] pos = new int [len][2];
        int [] res = new int [len];
        Arrays.sort(nums1);
        for (int i = 0; i < len; i++) {
            pos[i][0]=nums2[i];
            pos[i][1]=i;
        }
        Arrays.sort(pos, (o1, o2) -> o1[0]-o2[0]);
        int i=len-1,j=len-1;
        while (j>=0){
            if(nums1[i]>pos[j][0]){
                res[pos[j][1]]=nums1[i];
                i--;
            } else {
                res[pos[j][1]]=nums1[i-j];
            }
            j--;
        }
        return res;
    }
}
