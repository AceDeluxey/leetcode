import java.util.LinkedList;
import java.util.Stack;
/*
    946. 验证栈序列
    给定pushed和popped两个序列，每个序列中的 值都不重复，
    只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时，返回 true；否则，返回 false。

    思路：循环遍历，找开始pop的点。比如说pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
    一开始先遍历找pop的第一个数4，找到pushed中的4，在过程中1，2，3入栈了；poped的index指向5
     我们在这次循环中先到现有的栈顶看有没有3，有就继续循环pop。当栈顶没有符合的，说明可能还没入栈，此时继续进到主循环中，找下一个开始pop的地方
        这样到最后，如果可以pop出去栈就是空的；否则则不可以pop出这样的数组

    ON1  2MS 94.7%
 */
public class class946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0,index=0;i<pushed.length; i++){
            if(pushed[i] == popped[index]){
                if(++index==pushed.length){
                    break;
                }
                while(!stack.isEmpty() && popped[index]==stack.peek()){
                    index++;
                    stack.pop();
                    if(index==pushed.length ){
                       break;
                    }
                }
            } else{
                stack.push(pushed[i]);
            }
        }
        return stack.isEmpty() ? true: false;
    }
}
