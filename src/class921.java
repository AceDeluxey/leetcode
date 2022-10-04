import java.util.Stack;

/**
 * 921. 使括号有效的最少添加
 * 括号就栈就行了
 * 2ms 10%
 */
public class class921 {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i =0 ; i <s.length();i++){
            if(s.charAt(i)=='('){
                stack.push('(');
            } else if(s.charAt(i)==')'){
                if(stack.isEmpty()){
                    stack.push(')');
                } else{
                    if(stack.peek()=='('){
                        stack.pop();
                    } else{
                        stack.push(')');
                    }
                }
            }
        }
        return stack.size();
    }
}
