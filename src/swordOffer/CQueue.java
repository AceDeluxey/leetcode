package swordOffer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
/*
    剑指 Offer 09. 用两个栈实现队列
    思路：一个栈作入队队列，出栈时将该栈入栈到另一个栈，就反序了，这时可以出栈
        再入栈时同理

    165ms 20% 很慢

 */
/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
public class CQueue {
//    Stack<Integer> in ;
//    Stack<Integer> out;
    Deque<Integer> in ;
    Deque<Integer> out;
    public CQueue() {
//        in = new Stack<Integer>();
//        out = new Stack<Integer>();
        in = new LinkedList<Integer>();
        out = new LinkedList<Integer>();
    }

    public void appendTail(int value) {
        while(!out.isEmpty()){
            in.push(out.pop());
        }
        in.push(value);
    }

    public int deleteHead() {
        while(!in.isEmpty()){
            out.push(in.pop());
        }
        if(out.isEmpty()){
            return -1;
        } else{
            return out.pop();
        }
    }
}
