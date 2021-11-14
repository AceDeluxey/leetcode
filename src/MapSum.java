import java.util.HashMap;
import java.util.Map;

/**
 * 677. 键值映射

 思路：前缀哈希映射，可以学习,但是很奇怪的是我照着答案一模一样，我的跑不对，它的对

 12 ms 66%
 */
public class MapSum {
    Map<String , Integer> map;
    Map<String, Integer> preMap;
    public MapSum() {
        map = new HashMap<>();
        preMap =  new HashMap<>();
    }

    public void insert(String key, int val) {
        //更新后的值是差，可能正可能负
        int delta = val - map.getOrDefault(key,0);
        map.put(key, val);
        //注意substring的参数
        for( int i =1 ; i<=key.length(); i++){
            String pre = key.substring(0,i);
            preMap.put(pre, preMap.getOrDefault(pre,0)+delta);
        }
    }

    public int sum(String prefix) {
        return  map.getOrDefault(prefix,0);
    }
}
