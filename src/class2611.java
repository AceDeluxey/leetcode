import java.util.Arrays;
import java.util.Comparator;
/**
2611. 老鼠和奶酪
 有两只老鼠和 n 块不同类型的奶酪，每块奶酪都只能被其中一只老鼠吃掉。

 下标为 i 处的奶酪被吃掉的得分为：

 如果第一只老鼠吃掉，则得分为 reward1[i] 。
 如果第二只老鼠吃掉，则得分为 reward2[i] 。
 给你一个正整数数组 reward1 ，一个正整数数组 reward2 ，和一个非负整数 k 。

 请你返回第一只老鼠恰好吃掉 k 块奶酪的情况下，最大 得分为多少。

 来源：力扣（LeetCode）
 链接：https://leetcode.cn/problems/mice-and-cheese
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 实际上，第一只老鼠吃的这k块，要最大，就说明他吃的每一块比另一只大的越多越好
 那么根据这个原理，我们根据他们之间的差值排序index
 选取第一只吃的分数较大的前k个吃
 剩下的就给第二支吃
 */
public class class2611 {
    public static void main(String[] args) {
        class2611 test  = new class2611();
        int a[] = {1,1,3,4};
        int b[] = {4,4,1,1};

        test.miceAndCheese(a,b,2);
    }
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        Integer[] index = new Integer[reward2.length];
        for (int i = 0; i < index.length; i++) {
            index[i] = i;
        }
        Arrays.sort(index, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return reward1[b] - reward2[b] - (reward1[a] - reward2[a]);
            }
        });
        int res =0 ;

        for( int i =0 ; i <reward1.length;i++){
            res += reward2[i];
        }

        for( int i =0; i<k;i++){
            res += reward1[index[i]] - reward2[index[i]];
        }
        return res;

    }
}
