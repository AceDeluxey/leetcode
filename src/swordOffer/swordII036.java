package swordOffer;

import java.util.HashSet;
import java.util.Stack;

/**
 * 剑指 Offer II 036. 后缀表达式
 * 栈
 * 6ms 59%
 */
public class swordII036 {
    public int evalRPN(String[] tokens) {
        HashSet<String> set = new HashSet<>();
        set.add("+");set.add("-");set.add("*");set.add("/");
        Stack<Integer> stack = new Stack<>();
        for(String token : tokens){
            if(set.contains(token)){
                int b =  stack.pop();
                int a = stack.pop();
                if(token.equals("+")){
                    stack.push(a+b);
                } else if(token.equals("-")){
                    stack.push(a-b);
                } else if(token.equals("*")){
                    stack.push(a*b);
                } else if(token.equals("/")){
                    stack.push(a/b);
                }
            } else{
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
