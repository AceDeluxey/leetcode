import DataStructure.ListNode;

/**
 * 206. 反转链表
 * 就是遍历的时候把next指针调转一下就可以了 每次记录下prev节点
 */
public class class206 {
    public ListNode reverseList(ListNode head) {
        ListNode  node = head;
        ListNode prev = null;
        while(node!=null){
            ListNode temp = prev;
            prev = node;
            node = node.next;
            prev.next = temp;
        }
        return prev;
    }
}
