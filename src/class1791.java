/**
 * 1791. 找出星型图的中心节点
 * 弱智题 不知道有什么意义
 * 就判断头两个数就可以了
 *
 * 0ms 100%
 */
public class class1791 {
    public int findCenter(int[][] edges) {
        return edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1]?edges[0][0]:edges[0][1];
    }
}
