package swordOffer;

import DataStructure.ListNode;

import java.util.List;

/**
 * 剑指 Offer II 021. 删除链表的倒数第 n 个结点
 * 就是双指针其实 先让第一个指针往后移动n个，当第一个到最后的时候，第二个指针恰好就是倒数第n个指针
 *而为了避免头部删除的问题，在头部前面加一个fakeHead即可
 *
 * 0ms 100% On
 */
public class swordII021 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null){
            return null;
        }
        ListNode fakeHead = new ListNode();
        fakeHead.next=head;
        ListNode node1 = fakeHead;
        ListNode node2 = fakeHead;
        for (int i = 0; i < n+1 && node2!=null; i++) {
            node2 = node2.next;
        }
        while (node2 != null) {
            node1 = node1.next;
            node2 = node2.next;
        }
        if(node1==fakeHead){
            head = node1.next.next;
        } else{
            node1.next = node1.next.next;
        }
        return head;
    }
}
