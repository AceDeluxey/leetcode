import java.util.*;

/**
 *      90. 子集 II
        给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。

        思路：DFS,回溯，两种走向，一种选，一种不选
            3ms 21%
 */
public class class90 {

    Set<List<Integer>> set = new HashSet<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //排序确保单调性，否则可能会有不同顺序的重复
        Arrays.sort(nums);
        DFS(nums, 0, new ArrayList());
        return new ArrayList<>(set);
    }

    private void DFS(int[] nums, int index, List temp) {
        //超过长度，说明从某个数开始的所有子集完毕
        if (index >= nums.length) {
            set.add(new ArrayList<>(temp));
            return;
        }

        //在每个位置，都有选和不选两种情况
        temp.add(nums[index]);
        DFS(nums, index + 1, temp);

        //去掉不选
        temp.remove(temp.size() - 1);
        DFS(nums, index + 1, temp);
    }

}

