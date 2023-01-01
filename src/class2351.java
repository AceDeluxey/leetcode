import java.util.HashSet;
import java.util.Set;

/**
 * 2351. 第一个出现两次的字母
 * 简单
 */
public class class2351 {
    public char repeatedCharacter(String s) {
        Set<Integer> set = new HashSet<>();
        for( int i =0;i<s.length();i++){
            if(set.contains(s.charAt(i)-'a')){
                return s.charAt(i);
            } else{
                set.add(s.charAt(i)-'a');
            }
        }
        return 'a';
    }
}
