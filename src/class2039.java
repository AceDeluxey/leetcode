import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 2039. 网络空闲的时刻
 * 1ms 100%
 */
public class class2039 {
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        int len = patience.length;
        List<Integer>[] adj =  new ArrayList[len];
        for (int i = 0; i < len; ++i) {
            adj[i] = new ArrayList<Integer>();
        }

        for( int [] edge: edges){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        int ans = 0 ;
        boolean visited [] = new boolean[len];
        visited[0] = true;
        Queue<Integer> que = new ArrayDeque<>();
        que.offer(0);
        int cnt =0;
        while(!que.isEmpty()){
            cnt ++;
            for (int i = 0; i < que.size(); i++) {
                int temp = que.poll();
                for(int point :adj[temp]){
                    if(visited[point]){
                        continue;
                    }
                    que.offer(point);
                    /**
                     * 计算每个节点的空闲时间
                     */
                    int time = patience[point]*((2*cnt-1)/patience[point])+2*cnt+1;
                    ans = Math.max(ans,time);
                    visited[point] = true;
                }
            }
        }

        return ans;
    }
}
