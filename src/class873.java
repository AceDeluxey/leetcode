import java.util.HashMap;

/**
 * 873. 最长的斐波那契子序列的长度
 * 我不懂为什么要用dp 根本不用存状态啊 反正都是on2 存了干啥 还增加空间复杂度
 * 倒是可以用map 把数字和位置都存起来，这样遍历的时候能省一些时间
 * 195ms 44.3%
 */
public class class873 {
    public int lenLongestFibSubseq(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        int res = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j <arr.length -1; j++) {
                int cnt = 0;
                int first = arr[i], next = arr[j];
                int temp;
                while ((temp = map.getOrDefault(first + next, -1)) != -1) {
                    if (cnt == 0) {
                        cnt = 3;
                    } else {
                        cnt++;
                    }
                    first = next;
                    next = arr[temp];
                }
                res = Math.max(res, cnt);
            }
        }
        return res;
    }
}
