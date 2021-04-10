package swordOffer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/*
    剑指 Offer 50. 第一个只出现一次的字符
    在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。

    思路：就简单的HashMap
    31ms 36.2% ;  38.7M 74.5%

    改进:可以使用linkedHashMap,这样第二次遍历可以直接遍历HashMap，减少一定的时间
        如果使用普通的HashMap遍历可能会返回的不是第一个一次字符
 */
public class sword50 {
    public char firstUniqChar(String s) {
        HashMap<Character,Boolean> map = new LinkedHashMap<>();
        for( int i=0 ; i< s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), false);
            }else{
                map.put(s.charAt(i), true);
            }
        }
//        for( int i = 0; i<s.length(); i++){
//            if(map.get(s.charAt(i))){
//                return s.charAt(i);
//            }
//        }
        for(Map.Entry<Character,Boolean> entry : map.entrySet()){
            if(entry.getValue()){
                return entry.getKey();
            }
        }
        return ' ';
    }
}
