import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 1743. 从相邻元素对还原数组
 *
    思路：其实按这样写是很简单的想法，但是没有看到更好的解法了，必须遍历两次
    O(N) 93ms 92%

 */
public class class1743 {
    public int[] restoreArray(int[][] adjacentPairs) {
        HashMap<Integer, List<Integer>> map= new HashMap<>();
        int [] result = new int[adjacentPairs.length+1];
        //将数组写入hashMap
        for( int [] item : adjacentPairs){
            List<Integer> temp = map.getOrDefault(item[0],new ArrayList());
            temp.add(item[1]);
            map.put(item[0], temp);

            List<Integer> temp2 = map.getOrDefault(item[1],new ArrayList());
            temp2.add(item[0]);
            map.put(item[1], temp2);
        }

        //找到端点,将端点存入数组
        for(Map.Entry<Integer, List<Integer>> entry:map.entrySet()){
            if(entry.getValue().size() == 1){
                result[0]=entry.getKey();
                result[1]=entry.getValue().get(0);
                break;
            }
        }


        //从端点开始遍历
        for(int i=2;i<result.length; i++){
            result[i]=map.get(result[i-1]).get(0)==result[i-2]? map.get(result[i-1]).get(1):map.get(result[i-1]).get(0);
        }

        return result;
    }
}
