import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * 919. 完全二叉树插入器
 * 用链表按bfs存二叉树节点就可以，然后记录下下一次插入的父节点
 * 不过我想复杂了，把所有节点都存到list里了，但其实没有删除的话， 除了最后两层上面都不用存
 * 所以只用存开始没有2个子节点的节点开始后的所有节点就可以了 可以省时间和空间
 * 总体来说构建是On 遍历一遍树， 插入是O1
 * 但是因为多插了很多 最后只有22ms 30%
 */
public class CBTInserter {
    TreeNode root;
    //下一个插入的位置
    ArrayList<TreeNode> list;
    int index = -1;

    public CBTInserter(TreeNode root) {
        this.root = root;
        list = new ArrayList<>();
        findNow();
    }

    public int insert(int val) {
        TreeNode node = list.get(this.index);
        if(node.left==null){
            node.left = new TreeNode(val);
            list.add(node.left);
        } else{
            node.right = new TreeNode(val);
            list.add(node.right);
            index++;
        }
        return node.val;
    }

    public void findNow() {
        Queue<TreeNode> que = new ArrayDeque<>();
        que.add(this.root);
        list.add(root);
        int index = -1;
        while (que.size() > 0) {
            for (int i = 0; i < que.size(); i++) {
                int cnt = 0;
                TreeNode node = que.poll();
                index++;

                list.add(node);
                if (node.left != null) {
                    que.offer(node.left);
                    cnt++;
                }
                if (node.right != null) {
                    que.offer(node.right);
                    cnt++;
                }
                if (this.index == -1 && cnt < 2) {
                    this.index = index;
                }
            }
        }
    }

    public TreeNode get_root() {
        return this.root;
    }
}
