/**
        1306. 跳跃游戏 III
         这里有一个非负整数数组arr，你最开始位于该数组的起始下标start处。
        当你位于下标i处时，你可以跳到i + arr[i] 或者 i - arr[i]。

        思路：DFS，不过要加visit数组来标识，因为无论如何从一个点出去的情况都是一样的，所以每个只遍历一次就可以；
             也就是说从这个点出去，如果能到，已经返回了，如果不能到再去一次也没用

        2ms     99.88%
 */

public class class1306 {
    //标记在dfs中有没有找到flag
    boolean flag;

    boolean [] visited;
    public boolean canReach(int[] arr, int start) {
        visited = new boolean[arr.length];
        flag=false;

        DFS(arr, start);

        return flag;
    }
    private void DFS(int [] arr, int start){
        if(arr[start] == 0 ){
            flag = true;
        }

        if(flag || visited[start]){
            return;
        }

        visited[start] = true;

        //向两边DFS
        if(start+arr[start]<=arr.length-1){
            DFS(arr,start+arr[start]);
        }

        if(start-arr[start]>=0){
            DFS(arr,start-arr[start]);
        }

    }
}
