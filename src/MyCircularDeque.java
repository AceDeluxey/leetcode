/**
 * 641. 设计循环双端队列
 * 双向链表
 * 4ms 100%
 */
public class MyCircularDeque {
    public class LinkNode {
        int val;
        LinkNode left;
        LinkNode right;

        public LinkNode(int val) {
            this.val = val;
        }
    }

    int size = 0;

    LinkNode Front;
    LinkNode Last;
    int k = 0;

    public MyCircularDeque(int k) {
        this.k = k;
    }

    public boolean insertFront(int value) {
        if (size == k) {
            return false;
        }

        if (size == 0) {
            LinkNode node = new LinkNode(value);
            Front = node;
            Last = node;
        } else {
            LinkNode node = new LinkNode(value);
            node.right = Front;
            Front.left = node;
            Front = node;
        }
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (size == k) {
            return false;
        }
        if (size == 0) {
            LinkNode node = new LinkNode(value);
            Front = node;
            Last = node;
        } else {
            LinkNode node = new LinkNode(value);
            Last.right = node;
            node.left = Last;
            Last = node;
        }
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (size == 0) {
            return false;
        } else {
            if (size != 1) {
                Front.right.left = null;
                Front = Front.right;

            }
            size--;
        }
        return true;
    }

    public boolean deleteLast() {
        if (size == 0) {
            return false;
        } else {
            if (size != 1) {
                Last.left.right = null;
                Last = Last.left;
            }
            size--;
        }
        return true;
    }

    public int getFront() {
        if (size == 0) {
            return -1;
        }
        return Front.val;
    }

    public int getRear() {
        if (size == 0) {
            return -1;
        }
        return Last.val;
    }

    public boolean isEmpty() {
        if (this.size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() {
        if (this.size == this.k) {
            return true;
        } else {
            return false;
        }
    }
}
/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */