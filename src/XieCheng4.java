import java.util.*;

/**
 * https://blog.csdn.net/m0_38072683/article/details/129847132
 */
public class XieCheng4 {

    public static void main(String[] args) {
        int res = 0;
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        List<List<Integer>> list = new ArrayList<>();
        int[][] matrix = new int[n + 1][n + 1];
        for(int i =0 ; i<=n;i++){
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {

            int a = in.nextInt();
            int b = in.nextInt();
            int value = in.nextInt();
            matrix[a][b] = value;
            matrix[b][a] = value;

            List<Integer> l = list.get(a);
            l.add(b);
            list.set(a,l);
            l = list.get(b);
            l.add(a);
            list.set(b,l);
        }
        res=DFS(matrix,new HashSet<>(),n);
        System.out.println(res);
    }
    private  static int DFS(int[][] matrix, Set<Integer> set, int n){
        if(n-set.size()<=1){
            return 0;
        }
        int res = 0;
        for( int i=1;i<=n;i++){
            for (int j =1;j<=n;j++){
                if(set.contains(i)||set.contains(j)){
                    continue;
                }
                if(matrix[i][j]!=0){
                    set.add(i);
                    set.add(j);
                    res = Math.max(res,matrix[i][j]+DFS(matrix,set,n));
                    set.remove(i);
                    set.remove(j);
                }
            }
        }
        return res;
    }
//    private static int DFS(int index, boolean isChoose, int[][] matrix, boolean visited[], boolean ran[]) {
//        int[] row = matrix[index];
//        int res = 0;
//
//        for (int i = 1; i < row.length; i++) {
//            if (!visited[i]) {
//                //有边
//                if (row[i] != 0) {
//
//
//                }
//
//
//            }
//        }
//    }
}
