/*
// Definition for a Node.

*/

import DataStructure.ListNode;

/**
 *  138. 复制带随机指针的链表
 *
 *  思路：关键就是用hashmap记录起原有节点对应的节点，在遍历时去查，如果有了就不用创建，如果没有就创建，并写入map
 *
 *      0ms 100%; 38M 53%
 */
import java.util.HashMap;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}


public class class138 {
    HashMap<Node, Node> map = new HashMap<>();

    public Node copyRandomList(Node head) {
        Node temp = head;

        while (temp != null) {
            Node node;
            //获取当前节点
            if (map.containsKey(temp)) {
                node = map.get(temp);
            } else {
                node = new Node(temp.val);
                map.put(temp, node);
            }

            //连接下一个节点
            if (temp.next != null) {
                if (map.containsKey(temp.next)) {
                    node.next = map.get(temp.next);
                } else {
                    node.next = new Node(temp.next.val);
                    map.put(temp.next, node.next);
                }
            }


            //连接random
            if (temp.random != null) {
                if (map.containsKey(temp.random)) {
                    node.random = map.get(temp.random);
                } else {
                    node.random = new Node(temp.random.val);
                    map.put(temp.random, node.random);
                }
            }


            temp = temp.next;
        }

        return map.get(head);
    }
}
