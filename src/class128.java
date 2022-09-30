import java.util.HashMap;
import java.util.Map;

/**
 * 128. 最长连续序列
 * 并查集可以用Map
 * 二就是并查集可以用于解决求连续的问题 把连续看成一个集合
 *
 * 还有就是用并查集数长度 不能数到根节点用了几次，因为可能有很多个点在一排 数递归次数是数不到集合长度的
 * 所以在代码里又用了一次遍历数长度，比如 1 2 3 4 ，从1 数到4可能只用两次 ，但是最终都可以数到4，要用最终数到的去减
 * 这么以想好像在递归的时候数也可以
 *
 * 还有就是遍历的时候可以路径压缩，好像 这样每次都全部递归确实有点慢
 * 总体是O3N 1000ms 5% 还可以优化 1个N多
 * 吃饭了 不写了
 */
public class class128 {
    int res = 0 ;
    public int longestConsecutive(int[] nums) {

        Map<Integer,Integer> map = new HashMap<>();
        int len = nums.length;

        for (int num:nums){
           map.put(num,num);
        }

        // Merge Set
        for (int i =0  ; i < len ;i++){
            int a = nums[i]+1;
            if(map.containsKey(a)){
                int index1 = findRoot(a,map);
                int index2 = findRoot(a-1,map);
                map.put(index2,index1);
            }
        }

        // 数数
        for (int i =0  ; i < len ;i++){
            int a = nums[i];
            if(map.containsKey(a)){
                int index1 = findRoot(a,map);
                res = Math.max(res, index1 - a + 1);
            }
        }
        return res;
    }
    private int findRoot(int n, Map<Integer,Integer> map){

        while (n != map.get(n)){
            n = map.get(n);

        }

        return n;
    }
}
