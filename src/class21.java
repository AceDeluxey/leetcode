/**
 * 21. 合并两个有序链表
 *  将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 *  思路：合并两个链表时，在第一个节点前加个头是个很实用的方法，可以防止特判
 *       就是循环找到第一个链表中，适合第二个插入的位置，找到就插入
 *       其实可以不用index，写多余了懒得改
 *   On(length(l1)
 *   1ms 28%
 */

import DataStructure.ListNode;
public class class21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null ){
            return l2;
        } else if(l2 == null ){
            return l1;
        }
        //在第一个链前面加head,方便last计数
        ListNode head = new ListNode();
        head.next=l1;
        //记录l1的的位置
        ListNode last = head;
        ListNode index = l1;
        ListNode node2 = l2;
        while(node2 != null){
            //找到下一个插入位置
            while(index!=null && node2.val>index.val ){
                last = last.next;
                index = index.next;
            }

            //循环插入l2中的值
            ListNode temp = new ListNode();
            temp.val = node2.val;
            temp.next=index;
            last.next=temp;
            last=last.next;

            node2 =  node2.next;
        }
        return head.next;
    }
}
