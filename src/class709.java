
/*
    709. 转换成小写字母
    实现函数 ToLowerCase()，该函数接收一个字符串参数 str，
    并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
    很简单，凑个github记录
    0ms 100%
 */
public class class709 {
    public String toLowerCase(String str) {
        StringBuffer buf =new StringBuffer();
        for(int i=0;i<str.length(); i++ ){
            char temp=str.charAt(i);
            if(temp<='Z'&& temp>='A'){
                temp+=32;
            }
            buf.append(temp);
        }
        return buf.toString();
    }
}
