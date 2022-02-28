/**
 * 917. 仅仅反转字母
 * 字符串处理
 * 0ms 100%
 */
public class class917 {
    public String reverseOnlyLetters(String s) {
        StringBuilder sb = new StringBuilder();
        int index = s.length()-1;
        for(int i = 0 ; i < s.length();i++){
            char c = s.charAt(i);
            if((c<='Z' && c >='A')|| (c<='z' && c >='a')){
                char a = s.charAt(index);
                while(!((a<='Z' && a >='A')|| (a<='z' && a >='a'))){
                    a = s.charAt(--index);
                }
                sb.append(a);
                index--;
            } else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
