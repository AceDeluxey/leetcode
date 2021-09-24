
// Definition for a mulNode.

/**
     430. 扁平化多级双向链表
        多级双向链表中，除了指向下一个节点和前一个节点指针之外，它还有一个子链表指针，可能指向单独的双向链表。这些子列表也可能会有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示

    思路：倒是不难，用DFS，先遍历child再到next就行，为了不增加额外空间，在head上直接改，就要记下上一个遍历的点parent
        唯一不能理解的是leetcode的node = new Node()实例化以后，node是不等于null的
        然后就导致判断第一个节点错误，我不知道为什么不是null

        15ms 5%

 */

class mulNode {
    public int val;
    public mulNode prev;
    public mulNode next;
    public mulNode child;
}

public class class430 {

    mulNode parent;

    public mulNode flatten(mulNode head) {
        if (head == null) {
            return null;
        }
        parent = new mulNode();
        System.out.print(parent.val);
        DFS(head);
        return head;
    }

    private void DFS(mulNode mulNode) {

        //记录下一个节点，从下面分支后还能找回来
        //因为经过child后，可能next就变了
        mulNode next = mulNode.next;


        System.out.print(parent.val);
        System.out.print(mulNode.val);
        System.out.println("");
        parent.next = mulNode;
        if (parent.val != 0) {
            mulNode.prev = parent;
        }
        parent.child = null;
        parent = mulNode;


        //先后遍历next和child
        if (mulNode.child != null) {
            DFS(mulNode.child);
        }

        if (next != null) {
            DFS(next);
        }
    }
}
