import java.util.HashMap;

/**
 * 1372. 二叉树中的最长交错路径
 * 记忆化搜索
 */
public class class1372 {
    int l =0;
    HashMap<TreeNode,Integer[]> map ;
    public int longestZigZag(TreeNode root) {
        map = new HashMap<>();;
        DFS(root);
        return l ;
    }
    private  void DFS(TreeNode node){
        int len = Math.max(calLong(node,0),calLong(node,1));
        l = Math.max(l,len);
        if(node.left!=null){
            DFS(node.left);
        }
        if(node.right!=null){
            DFS(node.right);
        }
    }
    private int calLong(TreeNode node ,int flag){
        //flag==0，这一步往左
        Integer[] temp = map.getOrDefault(node,new Integer[]{-1,-1});
        if(temp[flag]!=-1){
            return temp[flag];
        }
        if(flag==0){
            if(node.left==null){
                return 1;
            } else{
                Integer[] temp1 = map.getOrDefault(node.left,new Integer[]{-1,-1});
                if(temp1[1]==-1){
                    return calLong(node.left,1) +1;
                } else{
                    return temp[1]+1;
                }
            }
        }else {
            if(node.right==null){
                return 1;
            } else{
                return calLong(node.right,0)+1;
            }
        }
    }
}
