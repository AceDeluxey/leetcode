/**
 * 1678. 设计 Goal 解析器
 * 不知道在考什么的题
 */
public class class1678 {
    public String interpret(String command) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < command.length(); i++) {
            if(command.charAt(i)=='G'){
                sb.append('G');
            } else if(command.charAt(i)=='(' && command.charAt(i+1)==')'){
                i++;
                sb.append('o');
            } else{
                i=i+3;
                sb.append("al");
            }
        }
        return  sb.toString();
    }
}
