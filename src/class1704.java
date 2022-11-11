import java.util.HashSet;

/**
 * 1704. 判断字符串的两半是否相似
 * 很简单
 * 4md 53%
 * 还可以用indexof mask等方法 不知道是不是比set快一些
 *
 */
public class class1704 {
    public boolean halvesAreAlike(String s) {
        int len = s.length();
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        int cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < len; i++) {
            if(set.contains(s.charAt(i))){
                if(i<len/2){
                    cnt1++;
                } else{
                    cnt2++;
                }
            }

        }
        return cnt1==cnt2;
    }
}
