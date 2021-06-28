package swordOffer;
import DataStructure.ListNode;

/**
 *      剑指 Offer 24. 反转链表
 *      定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *      双指针即可，记录下index的下一个节点
 *      0ms 100%
 */
public class sword24 {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null  ){
            return head;
        }

        ListNode pre = null,index = head;
        while (index!=null){
            ListNode temp = index.next;
            index.next = pre;
            pre = index;
            index=temp;
        }
        return pre;
    }
}
