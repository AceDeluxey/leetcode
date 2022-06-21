package swordOffer;

// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};

/**
 * 剑指 Offer II 029. 排序的循环链表
 * 这个题吧 就是根据测试案例改， 你说不看测试案例 面试考到 还真的基本不可能所有情况通过
 * 0ms 100%
 */
public class swordII029 {
    public Node insert(Node head, int insertVal) {
        if(head == null){
            head = new Node(insertVal,null);
            head.next = head;
        } else if(head.next == head){
             Node newNode = new Node(insertVal,head);
             head.next = newNode;
        } else
        {
            Node node = head;
            Node first = null;

            while(!(insertVal>= node.val && insertVal <= node.next.val)){
                //到首或者尾
                if(node.val>node.next.val){
                    if((insertVal>=node.val && insertVal>=node.next.val)|| (insertVal <= node.next.val)){
                        break;
                    }

                }
                node = node.next;
                //循环了一圈没找到 说明所有值一样 跳出
                if(node==head){
                    break;
                }
            }

            Node newNode = new Node(insertVal,node.next);
            node.next = newNode;
        }
        return head;
    }
}
