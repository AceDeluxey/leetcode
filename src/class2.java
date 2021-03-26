/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 * 思路：一遍遍历，如果遍历完一条链时另一条链还有，则遍历长链
 *      由于是逆序，所以要加flag进位，进位后直接修改链表中的val值
 *      另一个point在于要处理链尾的进位，分成链长相同和不同两种情况，需要新增节点
 *      时间100%,空间28%
 *      目前来看，链表题只要能一次遍历完，时间上都会比较优秀
 */
import DataStructure.*;

import java.util.List;

public class class2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode LN1=new ListNode();
        ListNode LN2=new ListNode();
        LN1=l1;
        LN2=l2;
        int flag=0;
        int sum=0;
        while(LN1.next!=null && LN2.next!=null){  //等长的那段
            sum=LN1.val+ LN2.val;
            if (flag == 1) {
                sum+=1;
                flag=0;
            }
            if(sum>=10){
                flag=1;
                sum-=10;
            }
            LN1.val=sum;
            LN2.val=sum;
            LN1=LN1.next;
            LN2=LN2.next;
        }

        sum=LN1.val+ LN2.val; //最短链最后一位相加
        if (flag == 1) {
            sum+=1;
            flag=0;
        }
        if(sum>=10){
            flag=1;
            sum-=10;
        }
        LN1.val=sum;
        LN2.val=sum;


        if(LN1.next == null ){  //使得LN1成为最长链
            if(LN2.next == null ){   //链长相同时处理链尾的进位
                if (flag == 1) {
                    ListNode temp=new ListNode();
                    temp.val=1;
                    LN1.next=temp;
                    flag=0;
                }
            } else{
                LN1.next=LN2.next;
            }
        }
        LN1=LN1.next;
        if(LN1!=null){
            while(true){
                sum=LN1.val;
                if (flag == 1) {
                    sum+=1;
                    flag=0;
                }
                if(sum>=10){
                    flag=1;
                    sum-=10;
                }
                LN1.val=sum;
                if(LN1.next == null){  //链长不同时处理链尾的进位
                    if (flag == 1) {
                        ListNode temp=new ListNode();
                        temp.val=1;
                        LN1.next=temp;
                    }
                    break;
                }
                LN1=LN1.next;
            }
        }

        return l1;
    }
}
