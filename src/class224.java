import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;

/**
     224. 基本计算器
        给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。

        思路：还是挺巧妙的，用栈存储每一个括号前符号的去括号符号
            先想到递归，每遇到(,就一直找到另一个),以此反复递归获得最终值，但是这样每个括号都要遍历两次
                用栈存符号比如1+(5-(1+2)),遇到第一个括号时，将+1入栈，代表这个括号掉后是正号，
                然后到了（1+2）前面，就成了前面去括号后再-，就是-1，第二个括号对应的就是-1；再以-1为外面的符号，打开1+2，变成-1-2
            其实也就是打开括号的过程，因为只有加减

        12ms 70%
 */
public class class224 {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        //默认是正号，例如(1+2),括号前没有符号是正号
        stack.push(1);
        int len = s.length();
        int i=0;
        int sign=1;
        int result=0;
        while( i < len ){
            if(s.charAt(i)=='+'){
                sign = stack.peek();
                i++;
            } else if(s.charAt(i)=='-'){
                sign = -stack.peek();
                i++;
            } else if ( s.charAt(i)=='(' ){
                stack.push(sign);
                i++;
            } else if (s.charAt(i)==')'){
                stack.pop();
                i++;
            } else if(s.charAt(i)==' '){
                i++;
            } else {
                int temp =0;
                while (i<len && Character.isDigit(s.charAt(i))){
                    temp = temp*10 + (s.charAt(i)-'0');
                    i++;
                }
                result += temp*sign;
            }
        }
        return result;
    }

}
