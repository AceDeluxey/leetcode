package swordOffer;

import java.util.LinkedList;

/**
 *      剑指 Offer 30. 包含min函数的栈
 *      定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
        思路：对于每一个状态的栈，其最小值都是固定的，那么我们只要在push过程中记录下每个长度的min值就好
            也就是除去stack用的list，我们还可以用一个list记录min值
        注意的点有两个，一是linkedList 的pop和push是针对第一个元素，但其实addLast和removeLast也可以完成，同时对一头操作就可以
        还有一个点就是测试用例中的[]，如果是null我这程序是通不过的，这里min.isEmpty() || x<min.peek()判断不了
        它的[]应该是不会push进去的东西，所以才能通过

         18ms 95%

 */
public class sword30 {
    LinkedList<Integer> stack;
    LinkedList<Integer> min;
    /** initialize your data structure here. */
    public sword30() {
        stack  = new LinkedList<>();
        min = new LinkedList<>();
    }

    public void push(Integer x) {

        if(min.isEmpty() || x<min.peek()){
            min.push(x);
        } else {
            min.push(min.peek());
        }

        stack.push(x);
        System.out.println(stack);
        System.out.println(min);
    }

    public void pop() {
        stack.pop();
        min.pop() ;
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min.peek();
    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */