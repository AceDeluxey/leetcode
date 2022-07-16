package swordOffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 剑指 Offer II 116. 省份数量
 * 其实很简单 每次dfs都会找得到一个省份
 * 1ms 85%
 */
public class swordII116 {
    public int findCircleNum(int[][] isConnected) {
        int len = isConnected.length;
        boolean visited[] = new boolean[len];
        int res = 0;
        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                res++;
            }
        }
        return res;
    }

    private void dfs(int[][] isConnected, boolean visited[], int i) {
        for (int j = 0; j < isConnected.length; j++) {
            if(isConnected[i][j] ==1 && !visited[j]){
                visited[j] = true;
                dfs(isConnected,visited,j);
            }
        }
    }
}
