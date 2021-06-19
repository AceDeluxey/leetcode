import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
    797. 所有可能的路径
    给一个有 n 个结点的有向无环图，找到所有从 0 到 n-1 的路径并输出（不要求按顺序）
    二维数组的第 i 个数组中的单元都表示有向图中 i 号结点所能到达的下一些结点（译者注：有向图是有方向的，即规定了 a→b 你就不能从 b→a ）空就是没有下一个结点了。

    思路:DFS，加回溯。这里的回溯就是每次DFS后，要把list removeLast
        有一个点很有意思，就是这个list，其实它在所有递归里都是一个list，只不过里面的值一直在变。
        所以往res里加的时候要new一个对象，否则它往里面加的永远是同一个地址的对象，然后因为这个list最后一个是[0]，所以最后就会变成很多[0]
        还有就是这题很难去用记忆化优化时间，因为每个都存一个List代价还是有点大，不过也可以考虑吧

    3ms 92%
 */
public class class797 {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        DFS(graph, 0,  new LinkedList<Integer>());
        return res;
    }
    private void DFS(int[][] graph, int index, LinkedList<Integer> list){
        list.add(index);
        if(index == graph.length -1 ){
            res.add(new ArrayList<>(list));
            //这样写所有list都是一样的[0]
//            res.add(list);
            return;
        }
        for( int i=0 ; i < graph[index].length ; i++){
            DFS(graph, graph[index][i], list);
            list.removeLast();
        }
    }
}
