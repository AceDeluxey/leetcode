import java.util.HashMap;
import java.util.LinkedList;

/**
 * 781. 森林中的兔子
 * 森林中，每个兔子都有颜色。其中一些兔子（可能是全部）告诉你还有多少其他的兔子和自己有相同的颜色。我们将这些回答放在 answers 数组里。
 * 返回森林中兔子的最少数量。
 *
 *  思路：我的解法更像数学题，即统计出说每个数字的有多少只
 *      说数字n的说明在某一个大小为n+1的集群中，如果说n的有m只
 *      那么对于n.就有至少有ceil((double)m/(n+1))*(n+1)只兔子
 *       至于统计每个数字的只数，使用了hashmap。但是遍历Map的效率比较低
 *        此外，貌似可以使用贪心算法
 *
 *       4ms 50.38% ; 37.9M 46.97%
 */
public class class781 {
    public int numRabbits(int[] answers) {
        int result=0;
        HashMap<Integer, Integer> map =new HashMap<>();
        for(int i=0;i<answers.length; i++){
            if(!map.containsKey(answers[i])){
                map.put(answers[i], 1);
            } else{
                map.put(answers[i], map.get(answers[i])+1);
            }
        }

        for (HashMap.Entry<Integer, Integer> entry : map.entrySet()) {
            int key= entry.getKey();
            int val= entry.getValue();
            result +=Math.ceil((double)val/(key+1))*(key+1);
        }
        return result;
    }
}
