import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 515. 在每个树行中找最大值
 * 2ms  88%
 * 行优先遍历
 */
public class class515 {
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<TreeNode>();

        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        que.offer(root);
        while (que.size() > 0) {
            int max = Integer.MIN_VALUE;
            int len = que.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = que.poll();
                if (node.left != null) {
                    que.offer(node.left);
                }
                if (node.right != null) {
                    que.offer(node.right);
                }
                max = Math.max(max, node.val);
            }
            res.add(max);
        }
        return res;
    }
}
