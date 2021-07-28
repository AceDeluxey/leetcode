import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import DataStructure.TreeNode;

/**
 *  863. 二叉树中所有距离为 K 的结点

         给定一个二叉树（具有根结点root），一个目标结点target，和一个整数值 K 。
        返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。

    思路：在target的子树中，找到这样的节点很容易，就DFS就行了
        关键是怎么在其他节点中找。一种方法是将其他节点转换为一个target为root的根节点，但这样我没想出来怎么写，答案里有写出来的
        比较简单的就是用Map记录下父节点，在dfs时增加一个维度父节点遍历，也就是转化为三叉树遍历，同时要注意避免循环

        O(N) 15ms 87%

 */
public class class863 {
    List<Integer> list;
    int targetK;
    TreeNode targetGloble;
    //存储父节点
    HashMap<TreeNode, TreeNode> map = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        list = new LinkedList<>();
        targetK = k;

        targetGloble = target;

        hashMap(root);

        DFS(target, 0 ,null);
        return list;
    }

    //构建子节点到父节点的Hash映射
    public void hashMap(TreeNode node) {

        if (node.left != null) {
            map.put(node.left, node);
            hashMap(node.left);
        }

        if (node.right != null) {
            map.put(node.right, node);
            hashMap(node.right);
        }

    }

    /**
     * DFS遍历，只不过在left和right的基础上，增加了父节点的遍历
     * 实质上是把二叉树的父节点变为多叉树来遍历
     * 但是由于有上下两个方向的遍历，很容易产生循环
     * 所以要记录下last,也就是上一个调用是在last节点调用的，以此来判断是不是产生了循环
     * @param node
     * @param k
     * @param last
     */
    public void DFS(TreeNode node, int k, TreeNode last) {

        if (node != null) {
            if (k == targetK) {
                list.add(node.val);
                return;
            } else if (k > targetK) {
                return;
            }

            //防止循环
            if (node.left != last) {
                DFS(node.left, k + 1, node);
            }
            if (node.right != last) {
                DFS(node.right, k + 1, node);
            }

            //如果有父节点，也遍历父节点
            //防止循环
            if (map.containsKey(node) && map.get(node) != last) {
                DFS(map.get(node), k + 1, node);
            }
        }
    }

}
