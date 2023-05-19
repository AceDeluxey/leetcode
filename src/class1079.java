import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 1079. 活字印刷
 *
 */
public class class1079 {
    public int numTilePossibilities(String tiles) {
        Map<Character,Integer> map  = new HashMap<>();
        for (char c : tiles.toCharArray()) {
            map.put(c,map.getOrDefault(c,0)+1);
        }
        Set<Character> tile = new HashSet<>(map.keySet());
        return dfs(tiles.length(),map,tile)-1;
    }
    public int dfs(int i , Map<Character,Integer> count,Set<Character> tile ){
        if(i==0){
            return  1;
        }
        int res = 1;
        /**
         * 到这里阶段有一个 所以初始是1
         */
        for (char t : tile) {
            if (count.get(t) > 0) {
                count.put(t, count.get(t) - 1);
                res += dfs(i - 1, count, tile);
                count.put(t, count.get(t) + 1);
            }
        }
        return res;


    }
}
