import java.util.HashMap;
import java.util.Map;

/**
 * 1624. 两个相同字符之间的最长子字符串
 *给你一个字符串 s，请你返回 两个相同字符之间的最长子字符串的长度 ，计算长度时不含这两个字符。如果不存在这样的子字符串，返回 -1 。
 *
 * 就map 挺简单的 1ms 76%
 *
 */
public class class1624 {
    public int maxLengthBetweenEqualCharacters(String s) {
        Map<Integer,Integer> map = new HashMap<>();
        int res = -1 ;
        for( int i =0 ; i <s.length();i++){
            int index =s.charAt(i)-'a';
            if(map.containsKey(index)){
                res = Math.max(res,i-map.get(index)-1);
            } else{
                map.put(index,i);
            }
        }
        return res;
    }
}
