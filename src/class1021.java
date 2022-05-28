import java.util.Stack;

/**
 * 1021. 删除最外层的括号
 * 栈 5ms 44.7%
 */
public class class1021 {
    int index = 0 ;
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        while(index<s.length()){
            sb.append(findPri(s));
        }
        return sb.toString();
    }
    //找一个primitive的去括号
    private  String findPri(String s){
        int start = index;
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(index++));
        while(!stack.isEmpty()){
            char temp = s.charAt(index);
            if(temp==')'){
                stack.pop();
            } else{
                stack.push(s.charAt(index));
            }
            index++;
        }
        return s.substring(start+1,index-1);
    }

    public static void main(String[] args) {

    }
}
