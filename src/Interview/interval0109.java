package Interview;

/**
 * 面试题 01.09. 字符串轮转
 * 就是加起来匹配以下 字符串匹配contains用kmp算法
 *
 * 0ms 100%
 */
public class interval0109 {
    public boolean isFlipedString(String s1, String s2) {
        if(s1.length()!=s2.length()){
            return false;
        } else{
            return (s1+s1).contains(s2);
        }
    }
}
