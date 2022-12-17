import java.util.HashSet;
import java.util.Set;

/**
 * 547. 省份数量
 *
 * 并查集
 * 不知道复杂度为啥这样高？？？
 * 6ms 10.66
 */
public class class547 {
    public static void main(String[] args) {
        int [][]a = {{1,1,0},{1,1,0}, {0,0,1}};
        class547 test = new class547();
        test.findCircleNum(a);
    }
    public int findCircleNum(int[][] isConnected) {
        int len = isConnected.length;
        int [] map = new int [len];
        for( int i =0 ;  i <len;i++){
            map[i]=i;
        }
        for (int i =0 ; i <  len;i++){
            for (int j =0;j<len;j++){
                if(isConnected[i][j]==1){
                    merge(map,i,j);
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i =0 ; i < len;i++){
            set.add(findRoot(map,i));
        }
        return set.size();
    }
    private void merge(int map[],int x,int y ){

        int rootX = findRoot(map,x);
        int rootY = findRoot(map,y);
        if(rootX!=rootY){
            map[rootX] = map[rootY];
        }



    }
    private int findRoot(int map[],int n ){
        while(n!=map[n]){
            n=map[n];
        }
        return n;
    }
}
