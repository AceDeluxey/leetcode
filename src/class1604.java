import java.util.*;

/**
 * 1604. 警告一小时内使用相同员工卡大于等于三次的人
 *  照着答案写的，但是有两个点值得注意
 *  一个是putIfAbsent，对于put
 *  另一个是对list进行排序，可以用Collections.sort
 *  还有就是对list中的字符串首字符排序，也可以用Collections
 *  43ms 77%
 */
public class class1604 {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> timeMap = new HashMap<String, List<Integer>>();
        int n = keyName.length;
        for (int i = 0; i < n; i++) {
            String name = keyName[i];
            String time = keyTime[i];
            timeMap.putIfAbsent(name, new ArrayList<Integer>());
            int hour = (time.charAt(0) - '0') * 10 + (time.charAt(1) - '0');
            int minute = (time.charAt(3) - '0') * 10 + (time.charAt(4) - '0');
            timeMap.get(name).add(hour * 60 + minute);
        }
        List<String> res = new ArrayList<String>();
        Set<String> keySet = timeMap.keySet();
        for (String name : keySet) {
            List<Integer> list = timeMap.get(name);
            Collections.sort(list);
            int size = list.size();
            for (int i = 2; i < size; i++) {
                int time1 = list.get(i - 2), time2 = list.get(i);
                int difference = time2 - time1;
                if (difference <= 60) {
                    res.add(name);
                    break;
                }
            }
        }
        Collections.sort(res);
        return res;
    }
}
