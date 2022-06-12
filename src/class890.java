import java.util.*;

/**
 * 890. 查找和替换模式
 * 就构造两个Map看看是不是互相映射就好了
 * 3ms 10%
 */

public class class890 {
    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        //记录映射关系
//        char[] map = new char[26];
        Map<Character,Character> map ;
        Map<Character,Character> map2 ;
        List<String> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            map =  new HashMap<>();
            map2 =  new HashMap<>();
            String word = words[i];
            Boolean flag = true;
            for(int j = 0; j < pattern.length(); j++){
                if(map.containsKey(pattern.charAt(j)) && map2.containsKey(word.charAt(j))){
                    if(map.get(pattern.charAt(j))!=word.charAt(j) || map2.get(word.charAt(j))!=pattern.charAt(j)){
                        flag = false;
                        break;
                    }
                } else if(!map.containsKey(pattern.charAt(j)) && !map2.containsKey(word.charAt(j)))
                {
                    map.put(pattern.charAt(j), word.charAt(j));
                    map2.put(word.charAt(j),pattern.charAt(j));
                } else{
                    flag = false;
                    break;
                }
            }
            if(flag){
                res.add(word);
            }
        }
        return res;
//
//        for (int i = 0; i < words.length; i++) {
//            Arrays.fill(map, '.');
//            String word = words[i];
//            for (int j = 0; j < word.length(); j++) {
//
//                Boolean flag = true;
//                for (int k = 0; k < map.length; k++) {
//                    if (map[k] == pattern.charAt(j)) {
//                        flag = false;
//                        break;
//                    }
//                }
//                if (!flag) {
//                    break;
//                } else{
//                    int index = word.charAt(j) - 'a';
//                    if (map[index] == '.') {
//                        map[index] = pattern.charAt(j);
//                    }
//                }
//
//            }
//            res.add(word);
//        }
//        return res;
    }

    public static void main(String[] args) {
        String[] words = {"abc", "deq", "mee", "aqq", "dkd", "ccc"};
        findAndReplacePattern(words, "abb");
    }
}
