import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 199. 二叉树的右视图
 * 二叉树的层次遍历  取最右边一个就行 队列
 *
 * 1ms 80%
 */
public class class199 {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> que = new ArrayDeque();
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        que.offer(root);

        while (!que.isEmpty()) {
            //记录一层的节点数
            int nums = que.size();
            for (int i = 0; i < nums; i++) {
                TreeNode temp = que.poll();
                //最后一个
                if (i == nums - 1) {
                    list.add(temp.val);
                }

                if (temp.left != null) {
                    que.offer(temp.left);
                }

                if (temp.right != null) {
                    que.offer(temp.right);
                }

            }
        }
        return list;
    }
}
