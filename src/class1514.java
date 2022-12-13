import javafx.util.Pair;

import java.util.*;

/**
 * 1514. 概率最大的路径
 * 图的题是真不知道怎么调试
 * 测试案例太多了
 * <p>
 * 迪杰斯特拉算法，每次遍历为什么要选最短的路径作为下一个遍历的？
 * 最开始以为这一步是多余的，但其实不是
 * 因为其实每一步只遍历了一个点，不能保证遍历出来的就是最短路径
 * 但是每次遍历后最短的一个可以保证，为什么，因为到其他点都比这个点长了，说明不存在从其他点绕到最短的点的情况了
 * 就比如 1 2 3 ， 1到2是1 ，2到3 是2，1到3是4
 * 那么1到2 是1 ，遍历完一轮就知道它是最短的，因为你不可能从其他去绕，其他更长
 * 所以每一步选择最短的是比较关键的
 * <p>
 * <p>
 * 第一次写超时了是因为，遍历这个边，实际上应该把他写到链表里，不然每次都要重新遍历一遍边集合
 *
 * 12/13 不是 都改成邻接链表了 为啥还是超时啊 崩溃了  找最大值这个步骤也要优化的吗
 */
public class class1514 {
    public static void main(String[] args) {
        class1514 test = new class1514();
        int n = 3;
        int[][] edges = {{0, 1}};
        double[] succ = {0.5};
        int start = 0;
        int end = 2;
        test.maxProbability(n, edges, succ, start, end);
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Set<Integer> visited = new HashSet<>();
        //最短路径
        Map<Integer, Double> map = new HashMap<>();
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Pair> temp =new ArrayList<>();
            graph.add(temp);
        }
        //构造图的链表
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            graph.get(edge[0]).add(new Pair(edge[1],succProb[i]));
            graph.get(edge[1]).add(new Pair(edge[0],succProb[i]));
        }
        for (int i = 0; i < n; i++) {
            map.put(i, 0.0);
        }
        map.put(start, 1.0);
        //每个点都要遍历一次，从start开始
        int selected = start;
        while (visited.size() != n) {
            List<Pair> edges_for_node = graph.get(selected);
            for(Pair<Integer,Double> edge:edges_for_node){
                int e =edge.getKey();
                double pos = edge.getValue();
                if(!visited.contains(e)){
                    map.put(e, Math.max(map.get(selected) * pos, map.get(e)));
                }
            }
            //不能直接遍历
//            for (int i = 0; i < edges.length; i++) {
//                int[] edge = edges[i];
//                int s = edge[0];
//                if (s == selected) {
//                    //边的end
//                    int e = edge[1];
//                    //更新相连的概率
//                    if (!visited.contains(e)) {
//                        map.put(e, Math.max(map.get(s) * succProb[i], map.get(e)));
//                    }
//
//                }
//
//                s = edge[1];
//                if (s == selected) {
//                    //边的end
//                    int e = edge[0];
//                    //更新相连的概率
//                    if (!visited.contains(e)) {
//                        map.put(e, Math.max(map.get(s) * succProb[i], map.get(e)));
//                    }
//                }
//            }
            visited.add(selected);
            //选取下一个遍历的，选取下一个遍历的要选最大路径对应的，具体看最上面注释的解释
            double max = 0.0;
            int selecteBefore = selected;
            for (int i = 0; i < n; i++) {
                if (!visited.contains(i)) {
                    if (max < map.get(i)) {
                        max = map.get(i);
                        selected = i;
                    }
                }
            }
            if (selected == selecteBefore) {
                //说明没得走了，没路了
                break;
            }
        }
        return map.get(end);
    }
}
