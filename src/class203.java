import DataStructure.ListNode;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/**
 *      203. 移除链表元素
 *      给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 *
 *      思路：关键是两个node，一个是在头前加一个节点，处理第一个元素是val的清空。
 *             第二个Node是遍历中记录的preNode
 *
 *      1ms 99%
 */
public class class203 {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return head;
        }
        //在Head前面加一个不是val的节点，这样如果第一个节点是val,删除方式就保持不变。最后返回第二个节点就可以。
        ListNode firstNode = new ListNode(head.val+1,head);
        ListNode node = firstNode;
        //遍历中上一个node
        ListNode preNode = new ListNode();
        while (node != null ){
            if(node.val==val){
                if(node.next ==null){
                    preNode.next=null;
                } else{
                    preNode.next = node.next;
                }
            } else{
                preNode=node;
            }
            node=node.next;
        }
        return firstNode.next;
    }
}
