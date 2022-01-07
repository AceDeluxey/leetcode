/**
 * 1614. 括号的最大嵌套深度
 * 思路：因为是合法的括号字符串，所以遇到/(+一层深度，遇到)减一层深度，然后得到最大值就好
 *
 * 简单
 * 0ms 100%
 */
public class class1614 {
    public int maxDepth(String s) {
        int depth = 0;
        int max = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                depth++;
                if (depth > max) {
                    max = depth;
                }
            } else if (c == ')') {
                depth--;
            }
        }
        return max;
    }
}
