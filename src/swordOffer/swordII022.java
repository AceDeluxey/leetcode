package swordOffer;

import DataStructure.ListNode;
import java.util.Set;
import java.util.HashSet;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

/**
 * 剑指 Offer II 022. 链表中环的入口节点
 * 3ms 10%
 */
public class swordII022 {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while(head != null){
            if(set.contains(head)){
                return head;
            } else{
                set.add(head);
            }
            head = head.next;
        }
        return null;
    }
}
