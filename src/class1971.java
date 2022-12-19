/**
 * 1971. 寻找图中是否存在路径
 * 并查集简单
 * 11ms 70%
 */
public class class1971 {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        int map[] = new int[n];
        for (int i = 0; i < n; i++) {
            map[i]=i;
        }
        for(int []edge:edges){
            merge(map,edge[0],edge[1]);
        }
        return findRoot(map,source)==findRoot(map,destination);
    }
    private void merge(int[]map,int x ,int y){
        int xr = findRoot(map,x);
        int yr = findRoot(map,y);
        map[xr] = map [yr];
    }
    private int findRoot(int []map,int n ){
        while(n!=map[n]){
            n= map [ n];
        }
        return n;
    }
}
