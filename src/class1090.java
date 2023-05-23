import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 1090. 受标签影响的最大值
 * 毫无任何难度
 * 就是阅读理解题
 * 执行用时：
 * 16 ms
 * , 在所有 Java 提交中击败了
 * 73.96%
 * 的用户
 *
 */
public class class1090 {
    public static void main(String[] args) {
        class1090 test = new class1090();

    }
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int  n = values.length;
        int  [][] pairs = new int[n][2];
        for ( int i =0 ; i<n;i++){
            pairs[i][0] = values[i];
            pairs[i][1] = labels[i];
        }
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] a1, int[] a2) {
                return a2[0]-a1[0];
            }
        });
        /**
         * 记录每个标签的情况
         */
        Map<Integer,Integer> map = new HashMap<>();
        int res =0 ;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if(cnt >= numWanted){
                break;
            }
            int pair [] = pairs[i];
            int val = pair[0];
            int label = pair[1];
            int labelCnt = map.getOrDefault(label,0);
            if(labelCnt+1>useLimit){
            } else{
                res +=val;
                map.put(label,labelCnt+1);
                cnt++;
            }
        }
        return res;
    }
}
