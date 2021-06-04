/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

/*
      160. 相交链表

        给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。
        如果两个链表没有交点，返回 null 。

      思路：希望node1和node2尽快相遇，那么二重循环显然不行。
            让node1遍历完一次后从B开始遍历，让Node2遍历完一次后从A开始遍历，它们两者到相交点的步数是一样的
            这样能保证在On的步数内两者一定会相遇，就能找到相交点。
         1ms 100%；
 */
import  DataStructure.ListNode;
public class class160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node1=headA;
        ListNode node2=headB;
        while(node1!=node2){
            node1= node1 == null?headB:node1.next;
            node2= node2 == null?headA:node2.next;
        }
        return node1;
    }
}
