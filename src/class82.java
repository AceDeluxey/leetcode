import DataStructure.ListNode;

import java.util.List;

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
//82. 删除排序链表中的重复元素 II
    //问题：现在写代码的情况在于，总是有了想法就开始写。代码对大部分情况适用，但是特殊情况难以满足。
    //导致每次做题都要提交很多次，难搞。

    /**
     * 思路：用一个指针记录最后一个满足前后不等的节点的位置，然后另一边
        遍历整个链表，同时用FLAG表示是否在经过重复的一段*/

public class class82 {
    public ListNode deleteDuplicates(ListNode head) {

        ListNode LN=new ListNode();
        ListNode tail=new ListNode();
        tail=null;
        LN=head;
        int flag=0;
        int replace=0;
        if(head!=null){
            while(LN.next!=null){
                if(LN.val!=LN.next.val){
                    if(flag==0){
                        tail=LN;
                    } else{
                        if(replace==1){     //解决头部重复问题，需要重新设置头部
                            if(LN.next!=null){
                                head=LN.next;
                            }else{
                                head=null;
                            }
                            replace=0;
                            continue;
                        }else{
                            if(tail!=null){
                                tail.next= LN.next;//flag=1时。说明重复部分已走完，拼接两个未重复部分
                            } else{
                                head=LN.next;
                            }

                            flag=0;
                        }
                    }
                    LN=LN.next;
                } else{
                    if(LN==head){
                        replace=1;
                    }
                    LN=LN.next;
                    flag=1;      //flag用来标记指针是否走完重复部分

                    if(LN.next==null){  //处理尾部重复
                        if(tail!=null){
                            tail.next=null;
                        } else{
                            head=null;
                        }
                    }
                }
            }
        }


        return head;
    }
}
