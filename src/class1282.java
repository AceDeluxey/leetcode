import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class class1282 {
//    List<List<Integer>>
/**
 * 1282. 用户分组
 * 2022 814 用map做的竟然还更慢
 * 因为频繁调用了map函数
 * 5ms 88%
 */
    /**
     * @param groupSizes
     * @return
     */
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        int len = groupSizes.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            int size = groupSizes[i];
            List<Integer> list = map.getOrDefault(size,new ArrayList<>());
            list.add(i);
            if(list.size()==size){
                res.add(list);
                map.put(size,new ArrayList<>());
            } else{
                map.put(size,list);
            }

        }
        return res;
    }

    /**
     * 以前写的 不知道为什么没有用map 用的是模拟类似的把  复杂度也不高 3ms 98%
     * @param groupSizes
     * @return
     */
//    public List<List<Integer>> groupThePeople(int[] groupSizes) {
//            List<List<Integer>> result=new ArrayList<List<Integer>> ();
//            int len=groupSizes.length;
//            int mem1=groupSizes[0];
//            int con[]=new int[len];
//
//            for(int i=0;i<len;i++){
//                if (con[i]==0){
//                    List res = new ArrayList<Integer>();
//                    int index=0;
//                    res.add(i);
//                    index ++;
//                    con[i]=1;
//                    if(index==groupSizes[i]){
//                        result.add(res);
//                        continue;
//                    }
//                    for( int j=i+1;j<len;j++){
//                        if(con[j]==0 && groupSizes[j]==groupSizes[i]){
//                            res.add(j);
//                            index++;
//                            con[j]=1;
//                            if(index==groupSizes[i]){
//                                break;
//                            }
//                        }
//                    }
//                    result.add(res);
//
//                }
//            }
//            return result;
//        };
}
//    class1282 test=new class1282();
//        int a[] = {2,1,3,3,3,2};
//        System.out.println(test.groupThePeople(a));