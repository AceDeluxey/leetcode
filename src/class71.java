import java.util.Stack;

/**
 * 71. 简化路径
 *
 * 思路:..和.实质上就是将路径简化，而后面的路径会被先减去；所以根据这一特性使用栈存储每个路径中的字符串
 *      最后用标准格式出栈即可
 *      12ms 5.26%
 *      把在循环里每次在string后面+一个字符改为substring，变为6ms 24.5%；以后尽量避免在循环中一直改字符串
 *      使用deQue，是5ms,说明java里deQue实现可能比stack效率要搞
 *
 *
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
            int index = i;
            while (i < path.length() && path.charAt(i) != '/') {
                i++;
            }
            String temp = path.substring(index,i);

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
