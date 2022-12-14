import java.util.Arrays;

/**1697. 检查边长度限制的路径是否存在
 * 乍一看会以为时最短路径题
 * 但不一样的是是要求每条边满足就可以，所以不用构图
 * 用并查集即可
 * 但是要将边排序，在每个query的限制以下的边 加入并查集
 * 这是因为query有多组，所以要保障每组query都满足条件，
 * 所以要排序限制
 * 还有一个有趣的点是 离线进行，query不必按照顺序进行，可以先进行其他处理再来进行query
 *
 * 真的很厉害这道题，虽然差不多是抄的
 * 但是还是很值得看
 * 1888ms 5%
 */
public class class1697 {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        //lamda
        Arrays.sort(edgeList, (a, b) -> (a[2] - b[2]));

        //这个lamda排序写的真的很牛批，没想到可以用其他数组来排序另一个数组，真的长见识了
        Integer[] index = new Integer[queries.length];
        for (int i = 0; i < queries.length; i++) {
            index[i] = i;
        }
        Arrays.sort(index, (a, b) -> (queries[a][2] - queries[b][2]));


        boolean[] res = new boolean[queries.length];
        int map[] = new int[n];
        //初始化根
        for (int i = 0; i < n; i++) {
            map[i] = i;
        }
        //遍历edge的下标
        int k =0 ;
        for (int i : index){
            while(k<edgeList.length && edgeList[k][2]< queries[i][2]){
                merge(map,edgeList[k][0],edgeList[k][1]);
                k++;
            }
            res[i]= (find(map,queries[i][0]))== find(map,queries[i][1]);
        }
        return res;
    }
    private void merge(int []map,int x, int y){
        int rootx = find(map,x);
        int rooty = find(map,y);
        map[rootx] = rooty;
    }
    private int find(int []map , int n) {
        while(map[n]!=n){
            n=map[n];
        }
        return n ;
    }
}
