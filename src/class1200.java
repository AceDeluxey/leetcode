import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1200. 最小绝对差
 * 排序 加遍历 我遍历了两次
 * 有的遍历一次 但是遍历一次的话要经常清空res，快不了多少感觉
 * 17ms  63%$
 */
public class class1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        if (arr.length <= 1) {
            return res;
        }
        int min =  Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            min = Math.min(min,arr[i]-arr[i-1]);
        }
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]-arr[i-1]==min){
                List<Integer>  temp = new ArrayList<>();
                temp.add(arr[i-1]);
                temp.add(arr[i]);
                res.add(temp);
            }
        }
        return res;
    }
}
