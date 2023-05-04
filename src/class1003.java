import java.util.Stack;

/**
 * 1003. 检查替换后的词是否有效
 * 16ms 40%
 * 这个确实是用stringBuilder当栈反而更好写一点
 * 学到了stk.delete
 */
public class class1003 {
    public boolean isValid(String s) {
        StringBuilder stk = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            stk.append(c);
            if (stk.length() >= 3 && stk.substring(stk.length() - 3).equals("abc")) {
                stk.delete(stk.length() - 3, stk.length());
            }
        }
        return stk.length()==0;


    }
}
