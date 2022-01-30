import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 2034. 股票价格波动
 * 思路:其他都简单，关键就是怎么获得最大值最小值，如果用列表什么的都需要自己去排序
 *  所以直接使用TreeMap，会以logn自动将索引排序，这样就是个有序集合
 *  直接firstkey取出最小key,lastkey取出最大key
 *  118ms 71.14% 主要就是在这个排序操作上
 */
public class class2031 {
    Map<Integer, Integer> map;
    TreeMap<Integer, Integer> prices;
    int recentTime = -1;

    public class2031() {
        map = new HashMap<>();
        prices = new TreeMap<>();
    }

    public void update(int timestamp, int price) {
        int lastPrice = map.getOrDefault(timestamp,0);
        //更新TreeMap中的value,有上一个就减去,如果个数为0就remove·
        if(lastPrice>0){
            int cnt = prices.get(lastPrice);
            if(cnt>1){
                prices.put(lastPrice,cnt-1);
            } else{
                prices.remove(lastPrice);
            }
        }
        //放入map
        map.put(timestamp, price);
        //将更新后的price放入TreeMap
        prices.put(price,prices.getOrDefault(price,0)+1);
        if (recentTime < timestamp) {
            recentTime = timestamp;
        }
    }

    public int current() {
        return map.get(recentTime);
    }

    public int maximum() {
        return prices.lastKey();
    }

    public int minimum() {
        return prices.firstKey();
    }
}
