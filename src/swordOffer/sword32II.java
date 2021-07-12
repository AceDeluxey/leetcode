package swordOffer;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    剑指 Offer 32 - II. 从上到下打印二叉树 II
    思路：普通的二叉树层次遍历，主要问题就是要按照每层来划分
        这样就需要在遍历上一层的时候，计算下一层的节点数；
        在除了最后一层的所有层中，下面节点就算没有也是null，所以对于上一层不是null的每一个节点，cnt+=2，即可计算下一层节点数
        虽然算不出最后一层节点数，但是由于que.poll的特点，就算队列空，也只会获取到Null，所以也没有影响
    1ms 95%
 */
public class sword32II {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();

        que.add(root);
        //下一层的节点数
        int nextLayer = 1;
        while (que.size() > 0) {
            List<Integer> temp = new ArrayList<>();
            int cnt = 0;
            for (int i = 0; i < nextLayer; i++) {
                //poll和remove一样，只是Poll为空时返回的是null不是异常
                TreeNode node = que.poll();
                if (node != null) {
                    cnt += 2;
                    temp.add(node.val);
                    que.add(node.left);
                    que.add(node.right);
                }
            }
            if (temp.size() > 0) {
                res.add(temp);
            }
            nextLayer = cnt;
        }
        return res;
    }
}
