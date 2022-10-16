import java.util.*;

/**
 * 886. 可能的二分法
 * 并查集
 * 进行了一点转换 并查集unit和find还是要背下模板比较方便
 * 初始化可以不用本身初始化，可以用-1来初始化。
 */
public class class886 {
    public boolean possibleBipartition(int n, int[][] dislikes) {
//        if (n <= 1) {
//            return true;
//        }
//        Set<Integer> set1 = new HashSet<>();
////        Set<Integer> set2 = new HashSet<>();
//        //先分成两组，如果成立则一个人不喜欢的都在一组
//        for (int i = 0; i < dislikes.length; i++) {
//            if(dislikes[i][0]==1){
//                set1.add(dislikes[i][1]);
//            }
//        }
//        for (int i = 0; i < dislikes.length; i++) {
//            Boolean flag1 = set1.contains(dislikes[i][0]);
//            Boolean flag2 = set1.contains(dislikes[i][1]);
//            if(!(flag1 ^ flag2)){
//                return false;
//            }
//        }
//        return true;

        //并查集
        int[] map = new int[n + 1];
        Arrays.fill(map,-1);
        List<Integer>[] l = new List[n + 1];
        for (int i = 0; i < n+1; i++) {
            l[i] = new ArrayList<>();
        }
        for (int[] d : dislikes) {
            l[d[0]].add(d[1]);
            l[d[1]].add(d[0]);
        }
        for (int i =1 ;i<n+1;i++){
            for (int j=0;j<l[i].size();j++){
                unit(l[i].get(0),l[i].get(j),map);
                if(isconnect(i,l[i].get(j),map)){
                    return false;
                }
            }
        }
        return true;
    }
    private void unit(int x,int y,int []map){
        x = findRoot(x,map);
        y = findRoot(y,map);
        if(x==y){
            return;
        }
        if(map[x]<map[y]){
            int temp = x;
            x = y;
            y=x;
        }
        map[x] +=map[y];
        map[y]=x;
    }
    private boolean isconnect(int x ,int y ,int []map){
        return findRoot(x,map)==findRoot(y,map);
    }
    private int findRoot(int x,int []map){
        return x<0?x:findRoot(map[x],map);
    }
}
