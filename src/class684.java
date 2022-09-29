/**
 * 684. 冗余连接
 * 并查集
 * 我理解的并查集大概思路就是  找集合的根节点
 * 最开始1 2 3 4 ，就是四个分开的集合
 * 边1 2 近来，1 2 就成了一个集合 那么怎么表示呢 就将1 的根节点设置未2 ，或者2的根设置为2，这里1设置为2
 * 2 3 来呢，2 的 根就是3
 * 再来个1 3 ， 发现1的根是3， 3 的根也是3 ，说明两个数拥有同根，也就是已经在一个集合黎
 * 现在再加进来，就说明有环了，就找到了
 * 看解析复杂度应该是Onlogn
 * 0ms 100%
 */
public class class684 {
    public int[] findRedundantConnection(int[][] edges) {
        int len = edges.length;
        int [] vectors = new int [len+1];
        //自己是自己的根节点
        for( int i =1 ;i<len+1;i++){
            vectors[i] = i;
        }

        for( int i =1 ;i<len+1;i++){
            int a = edges[i-1][0];
            int b = edges[i-1][1];
            int indexA=findRootIndex(a,vectors);
            int indexB =findRootIndex(b,vectors);
            if(indexA == indexB ){
                return new int []{a,b};
            } else{
                vectors[indexB] = indexA;
            }

        }
        return new int []{};
    }

    private int findRootIndex(int n,int [] vectors){
        while(vectors[n]!=n){
            n = vectors[n];
        }
        return n;
    }
}
