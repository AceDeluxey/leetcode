//83. 删除排序链表中的重复元素
import DataStructure.*;
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
// 时间超过100%,空间超过67%
public class class83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode LN=new ListNode();
        ListNode tail=new ListNode();
        LN=head;
        tail=head;
        int flag=0;
        if(head!=null){
            while(LN.next!=null){
                if(LN.val!=LN.next.val){
                    LN=LN.next;
                    if(flag==1){
                        tail.next = LN;
                        tail=LN;
                        flag=0;
                    } else{
                        tail=LN;
                    }

                } else{
                    LN=LN.next;
                    if(LN.next==null){
                        tail.next=null;
                    }
                    flag=1;
                }
            }
        }

        return head;
    }
}
