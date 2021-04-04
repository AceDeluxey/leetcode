/**
 * 98. 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 *  第一遍写的有些问题，看了看答案重新写的
 *  先用Integerd的MAX和MIN，竟然检查了
 *  改用Long的才过
 *
 *  100 41
 */
import DataStructure.TreeNode;
public class class98 {

    public boolean isValidBST(TreeNode root) {

        return DFS(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean DFS(TreeNode node, long min, long max){
        if( node == null){
            return true;
        }
        if(node.val<=min || node.val>=max){
            return false;
        }
        boolean left=DFS(node.left,min,node.val);
        boolean right=DFS(node.right,node.val,max);

        return left && right;
    }


    /**
     * 数组转换成二叉树的代码
     *
     */
    public  TreeNode convert(Integer[] array) {
        int floor = 0, count = 0;
        TreeNode[] treeNodes = new TreeNode[array.length];
        while (array != null && count < array.length) {
            int start = (int) Math.pow(2, floor) - 1;
            int end = (int) Math.pow(2, floor + 1) - 1;
            if (end > array.length) {
                end = array.length;
            }
            for (int i = start; i < end; i++) {
                if (array[i] != null) {
                    treeNodes[i] = new TreeNode(array[i]);
                } else {
                    treeNodes[i] = null;
                }
                if (i > 0) {
                    int parent = (i - 1) / 2;
                    if (parent >= 0) {
                        TreeNode pNode = treeNodes[parent];
                        if (pNode != null) {
                            if (i % 2 == 1) {
                                pNode.left = treeNodes[i];
                            } else {
                                pNode.right = treeNodes[i];
                            }
                        }
                    }
                }
                count++;
            }
            floor++;
        }
        return treeNodes[0];
    }
}

//    public static void main(String[] args) {
//        class98 test=new class98();
//        Integer[] array = new Integer[]{2, 1, 3};
//        TreeNode root = test.convert(array);
//        test.isValidBST(root);
//    }

/** 最开始的错解：误以为简化成分别判断根节点的左右两边大小就行了，
 *              其实不是，要判断每个节点的左右两边
 *      private int max_left=Integer.MIN_VALUE;
 *     private int min_right=Integer.MAX_VALUE;
 *     public boolean isValidBST(TreeNode root) {
 *         boolean left=DFS(root, Integer.MAX_VALUE,0, root.val);
 *         boolean right=DFS(root, Integer.MIN_VALUE,1,root.val);
 *         return left && right;
 *     }
 *     public boolean DFS(TreeNode node, int parrentVal,int flag,int rootValue){
 *         if( node == null){
 *             return true;
 *         }
 *
 *         boolean left=DFS(node.left,node.val,0,rootValue);
 *         boolean right=DFS(node.right,node.val,1,rootValue);
 *         if(flag==0 && node.val>max_left ){
 *             max_left= node.val;
 *         }
 *         if(flag==1 && node.val<min_right){
 *             min_right= node.val;
 *         }
 *         if (left && right && flag==0 && max_left <parrentVal  ){
 *             return true;
 *         }
 *         if(left && right && flag==1 && min_right>parrentVal ){
 *             return true;
 *         }
 *         return false;
 *     }
 */