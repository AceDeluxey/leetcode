import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56. 合并区间
 * 排序处理
 * 8ms 40%
 */
public class class56 {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<int[]>();
        //对第一个值升序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0]) return o1[1]-o2[1];
                return o1[0]-o2[0];
            }
        });
        list.add(intervals[0]);
        for(int i =1 ;i<intervals.length; i++){
            int last [] = list.get(list.size() - 1);
            int temp [] = intervals[i];
            if(temp[0]<=last[1]){
                int[] a = new int [2];
                if( temp[1]>=last[1]){
                    a[0]=last[0];
                    a[1]=temp[1];
                } else{
                    a[0]=last[0];
                    a[1]=last[1];
                }

                list.remove(list.size() - 1);
                list.add(a);
            } else{
                list.add(temp);
            }
        }
        return  list.toArray(new int [list.size()][]);
    }
}
