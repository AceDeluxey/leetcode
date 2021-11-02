import DataStructure.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
    237. 删除链表中的节点
    请编写一个函数，用于 删除单链表中某个特定节点 。在设计函数时需要注意，你无法访问链表的头节点 head ，只能直接访问 要被删除的节点 。

    思路：比较有意思的一题，一般删除都是要找到删除的前一个结点，与后一个结点连接，就完成删除了
        但是如果不能找到前一个结点，可以改变当前结点的值为下一个结点，再把当前结点连到下下个结点
        这样虽然不是真正的删除，但是也达成了删除的效果

    0ms 100%
 */
public class class237 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
