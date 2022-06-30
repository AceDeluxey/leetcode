package swordOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer II 016. 不含重复字符的最长子字符串
 * 写的是对的，就是我以为s里面只有字母来做的，没想到有符号空格啥的，
 * 感觉和答案写的一模一样 不知道为啥错
 *
 */
public class sword016 {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 1;
        int max = 0;
        if(s.length()<=1){
            return s.length();
        }

        Map<Integer,Integer> map = new HashMap<>();
        map.put(s.charAt(left)-'a',left);
        while ( right<s.length()) {
            char l = s.charAt(left);
            char r = s.charAt(right);
            int  rIndex= map.getOrDefault(s.charAt(right)-'a',-1);
            if (rIndex>=0){
                if(rIndex>left){
                    left = rIndex+1;
                }

            }
            max = Math.max(max,right-left+1);
            map.put(s.charAt(right)-'a',right);
            right++;
        }
        return max;
    }
}
