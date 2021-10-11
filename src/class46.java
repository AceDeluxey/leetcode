import java.sql.Struct;
import java.util.ArrayList;
import java.util.List;

/**
    46. 全排列
    给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。

    思路：回溯 DFS
    2mw 17%
 */
public class class46 {
    boolean visited[];
    List<List<Integer>> result;

    public List<List<Integer>> permute(int[] nums) {
        visited = new boolean[nums.length];
        result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = new ArrayList<>();
            DFS(nums, list, i);
        }
        return result;
    }

    private void DFS(int[] nums, List<Integer> list, int index) {
        list.add(nums[index]);
        visited[index] = true;
        //判断遍历完成的flag
        boolean flag = true;
        for (int i = 0; i < nums.length; i++) {
            if(!visited[i]){
                DFS(nums,list,i);
                flag = false;
            }
        }
        if(flag){
            //一定要new一个新对象，不然最后result里全是list这一个地址，全是[]
            result.add(new ArrayList<>(list));
        }
        list.remove(list.size() - 1);
        visited[index] = false;
    }
}
