import java.util.Stack;

/**
 * 71. 简化路径
 *
 * 思路:..和.实质上就是将路径简化，而后面的路径会被先减去；所以根据这一特性使用栈存储每个路径中的字符串
 *      最后用标准格式出栈即可
 *      12ms 5.26%
 */
public class class71 {
    public String simplifyPath(String path) {
        Stack stack = new Stack();
        for (int i = 0; i < path.length(); i++) {
            //Find the first /
            while (i < path.length() && path.charAt(i) == '/') {
                i++;
            }

            //Get the string between two '/'
            String temp = "";
            while (i < path.length() && path.charAt(i) != '/') {
                temp += path.charAt(i);
                i++;
            }

            //Back to parent folder
            if (temp.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }  //'.' means current dir
            } else if (!temp.equals(".") && !(temp.equals(""))) {
                stack.push(temp);
            }
        }

        String res = "";
        //Create the standard path
        while (!stack.isEmpty()) {
            res = "/" + stack.pop() + res;
        }

        return res.length() == 0 ? "/" : res;
    }
}
