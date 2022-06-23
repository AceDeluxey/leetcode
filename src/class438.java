import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *438. 找到字符串中所有字母异位词
 * 滑动窗口 ， 尝试起来还行 就是移动的时候把尾巴的加上， 头的减去就可以了
 * 学到了java里直接比较两个数组是否相等， Arrays.equals
 */
public class class438 {
    public List<Integer> findAnagrams(String s, String p) {
        if(s.length()<p.length()){
            return new ArrayList<>();
        }
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < p.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
            pCount[p.charAt(i) - 'a']++;
        }
        int start = 0, end = p.length() - 1;

        List<Integer> list = new ArrayList<>();
        while (end < s.length()) {
           if(Arrays.equals(sCount,pCount)){
               list.add(start);
           }
           if(end == s.length()-1){
               break;
           }
           sCount[s.charAt(start++)-'a']--;
           sCount[s.charAt(++end)-'a']++;
        }
        return list;
    }
}
