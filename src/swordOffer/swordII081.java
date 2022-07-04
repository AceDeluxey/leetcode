package swordOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer II 081. 允许重复选择元素的组合
 * 3ms 60%
 * 回溯 一开始担心 3 3 2 和  2 3 3 会重复 想着怎么去重
 * 但是其实不用去重 记录index 每次只往当前位置往后就可以了 这样的话只会出现 332 和233中的一种情况
 */
public class swordII081 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        DFS(res, path,  candidates,0, 0, target);
        return res;
    }

    private void DFS(List res, List path, int[] can, int sum, int pos, int target) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
        } else if (sum > target) {
            return;
        }

        for (int i = pos; i <can.length; i++) {
            path.add(can[i]);
            DFS(res, path,  can,sum+can[i], i, target);
            path.remove(path.size() - 1);
        }
    }
}
