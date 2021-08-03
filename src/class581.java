import java.util.Arrays;

/**
 * 581. 最短无序连续子数组
 * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序
 * <p>
 * 思路：clone可用于拷贝数组，用克隆后的数组排序后与原数组对比，用双指针看到哪一位开始不相等
 *
 *     OlognN 6ms 60%
 */
public class class581 {
    public int findUnsortedSubarray(int[] nums) {
        int temp[] = nums.clone();
        Arrays.sort(temp);
        //找到左端开始的有序坐标
        int index1 = 0, index2 = nums.length - 1;
        while (index1 < nums.length && nums[index1] == temp[index1]) {
            index1++;
        }
        //找到右边的坐标
        while (index2 >= 0 && nums[index2] == temp[index2]) {
            index2--;
        }

        return index2 < index1 ? 0 : index2 - index1 + 1;
    }
}
