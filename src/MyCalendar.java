/**
 * 729. 我的日程安排表 I
 * 这种插入的结构一般首先想到的是二分查找，但是二分查找的话可变长度的类好像得自己写比较复杂，要排序
 * 但是二叉搜索树的数据结构就很好写 而且复杂度也是Onlogn 以后可以多用
 *
 * 11ms 100%R
 */
public class MyCalendar {
    class SearchTree {
        SearchTree left;
        SearchTree right;
        int start;
        int end;

        SearchTree(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    SearchTree root;

    public MyCalendar() {

    }

    public boolean book(int start, int end) {
        if (root == null) {
            root = new SearchTree(start, end);
            return true;
        } else {
            SearchTree node = root;
            while (true) {
                //排除两种可能就只能重合了
                if (end <= node.start) {
                    if (node.left == null) {
                        node.left = new SearchTree(start, end);
                        return true;
                    } else {
                        node = node.left;
                    }

                } else if (start >= node.end) {
                    if (node.right == null) {
                        node.right = new SearchTree(start, end);
                        return true;
                    } else {
                        node = node.right;
                    }

                } else{
                    return false;
                }
            }
        }

    }
}
