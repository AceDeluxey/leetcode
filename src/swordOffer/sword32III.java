package swordOffer;

import DataStructure.TreeNode;

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

/**
 *  剑指 Offer 32 - III. 从上到下打印二叉树 III
 *  请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 *
    思路：加入layer计数到第几层了，如果是双数层则将Val先入栈，循环一层后再出栈进入队列，这样就可以交叉地输出二叉树
    2ms 28%
 */
public class sword32III {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();

        que.add(root);
        //下一层的节点数
        int nextLayer = 1;
        //用layer进行计数
        int layer = 1;
        while (que.size() > 0) {
            List<Integer> temp = new ArrayList<>();
            int cnt = 0;
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < nextLayer; i++) {
                //poll和remove一样，只是Poll为空时返回的是null不是异常
                TreeNode node = que.poll();
                if (node != null) {
                    cnt += 2;
                    if (layer % 2 == 0) {
                        stack.push(node.val);
                    } else {
                        temp.add(node.val);
                    }
                    que.add(node.left);
                    que.add(node.right);
                }
            }
            if (layer % 2 == 0) {
                while (!stack.isEmpty()) {
                    temp.add(stack.pop());
                }
            }
            if (temp.size() > 0) {
                res.add(temp);
            }
            layer++;
            nextLayer = cnt;
        }
        return res;
    }
}
