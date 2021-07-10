import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 981. 基于时间的键值存储
     * 如果像我这样用两个map是没什么难的，首先key对应了一个treeMap,存就直接往这个treeMap里存
     * 要获取的话，使用treeMap的floorEntry方法，就能获取到小于输入值的最大键值的entry，直接就满足题意了
 *   如果要自己实现floorEntry方法,就是列表+二分，会难一些
 *   142ms 100%
 */
public class class981 {
    /**
     * Initialize your data structure here.
     */
    HashMap<String, TreeMap<Integer, String>> map;

    public class981() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> tmpMap = map.getOrDefault(key, new TreeMap<>());
        tmpMap.put(timestamp, value);
        map.put(key, tmpMap);
    }

    public String get(String key, int timestamp) {
        Map.Entry<Integer, String> entry = map.getOrDefault(key, new TreeMap<>()).floorEntry(timestamp);
        return entry == null ? "" : entry.getValue();
    }
}
/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */