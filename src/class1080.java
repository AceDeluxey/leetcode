/**
 * 1080. 根到叶路径上的不足节点
 *
 * 谈一谈为什么节点自己删除自己删除不掉 （在树里—)
 * 就是本来想删除一棵树里的node节点，我以为node ==null就行了
 * 其实这样只是移除了node对于对象的指向，对象还是存在于堆里
 * 这时候他的父亲节点p 的left或者右指针还指向着这个对象，所以这个对象其实没有被删除
 * 只是node的指向被移除了
 * 所以删除树里的节点，要在他的父节点处删除才行
 *
 * 不过还是看错题了，我以为到叶子节点不到Limit就要删除
 * 结果是经过的每种可能的根叶路径和都小于limit
 *  那写的还是有点问题。
 */
public class class1080 {
    /**
     * 因为-105 <= Node.val <= 105
     * 所以设置一个超过范围的值当flag
     * 当val==这个值的时候说明要删除
     */
    public final int flag = (int) 10e6;
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        dfs(root,limit);
        return root;
    }
    private int dfs(TreeNode node, int limit){
        if( node == null){
            return 0;
        }

        int left = dfs(node.left,limit);
        if(node.left != null &&node.left.val ==  flag){
            node.left =null;
        }
        int right = dfs(node.right,limit);
        if(node.right != null && node.right.val ==  flag){
            node.right =null;
        }
        //判断最大值是否小于就可以了
        int res =Math.max(left,right)+node.val;
        System.out.println(res);
        //后序遍历，保证左右都遍历完才回来判断

        if(res<limit){
            node.val = flag;
        }
        return res;
    }
}
/**
 * 8
 * 9
 * 13
 * -99
 * -99
 * -198
 * 15
 * 12
 * 13
 * -86
 * -99
 * 14
 * 21
 * 24
 * 25
 */