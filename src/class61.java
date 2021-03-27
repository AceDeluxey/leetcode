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
 * 61. 旋转链表
 *  给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 *
 *  思路：链表题最高的目标就是一次遍历
 *  这题是往右循环K个位置，那么说明后k个节点要脱离链表，形成头部再链接到前面
 *  关键就是如何一次遍历寻找后k个节点
 *  用两个指针，一个指针指向head,另一个指向head+k
 *  这样循环一次当index2到达链尾时，index1恰好指向后K个node的前一个
 *  确实效率也很高，时间100%,空间85%
 */
import DataStructure.*;
public class class61 {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode index1 =new ListNode();
        index1=head;
        ListNode index2=new ListNode();
        index2=head;
        ListNode temp=null;
        int cnt=0;
        if(head!=null){
            for(int i=0;i<k;i++){
                if(index2.next!=null){
                    index2=index2.next;
                    cnt++;
                } else{
                    cnt++;
                    index2=head;
                    i=-1;
                    k=k%cnt;
                }

            }
            while(index2.next!=null){
                index1 = index1.next;
                index2 = index2.next;
            }
            index2.next = head;
            temp =index1.next;
            index1.next=null;
        }

        return temp;

    }
}
//class61 test =new class61();
//        int []a={0,1,2};
//        ListNode head=new ListNode(a);
//
//        head=test.rotateRight(head,4);
//        while(head!=null){
//            System.out.println(head.val);
//            head=head.next;
//        }