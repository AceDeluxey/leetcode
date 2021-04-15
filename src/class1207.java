import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/*
    1207. 独一无二的出现次数
    给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
    如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。

    思路：HashMap统计每个数字的次数，再将次数加入Set，查看是否有重复
         没想到效率还很高
         遍历HashMap用EntrySet最快
         2ms 98%;
 */
public class class1207 {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map =new HashMap<Integer, Integer>();
        HashSet<Integer> set= new HashSet<>();
        for(int i=0;i<arr.length; i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            } else{
                map.put(arr[i],1);
            }
        }

        Set<Map.Entry<Integer,Integer>> entrySet=map.entrySet();
        for(Map.Entry<Integer, Integer> entry : entrySet){
            if(set.contains(entry.getValue())){
                return false;
            } else{
                set.add(entry.getValue());
            }
        }
        
       return  true;
    }
}
//    Set<HashMap.Entry<Integer, Integer>> entrySet = map.entrySet();
//        for (HashMap.Entry<Integer, Integer> entry : entrySet) {
//            entry.getValue();
//        }