import java.util.ArrayList;
import java.util.List;

/**
 * 589. N 叉树的前序遍历
 * 0ms 100%
 */
//class Node {
//    public int val;
//    public List<Node> children;
//
//    public Node() {}
//
//    public Node(int _val) {
//        val = _val;
//    }
//
//    public Node(int _val, List<Node> _children) {
//        val = _val;
//        children = _children;
//    }
//};
//public class class589 {
//    List<Integer> result;
//    public List<Integer> preorder(Node root) {
//        result = new ArrayList<Integer>();
//        DFS(root);
//        return result;
//    }
//    private void DFS(Node node){
//        if(node == null){
//            return;
//        }
//        result.add(node.val);
//        for(Node temp : node.children){
//            DFS(temp);
//        }
//    }
//}
