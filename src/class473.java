import java.util.Arrays;

/**
 * 473. 火柴拼正方形
 * DFS 回溯
    每个边顺着选，看能让你还不能满足每个边最后都小于等于len，如果所有都满足，说明刚刚能构成正方形
    51ms 43%
 */
public class class473 {
    public  boolean makesquare(int[] matchsticks) {
//        int sum = 0, edge = 0;
//        for (int i = 0; i < matchsticks.length; i++) {
//            sum += matchsticks[i];
//        }
//        if (sum % 4 != 0) {
//            return false;
//        } else {
//            edge = sum / 4;
//        }
//        Arrays.sort(matchsticks);
//
//        //现在凑出的边的长度和边的数量
//        int temp = 0, cnt = 0;
//        for (int i = 0; i < matchsticks.length; i++) {
//            if (temp < edge) {
//                temp += matchsticks[i];
//                if(temp==edge){
//                    temp =0;
//                    cnt ++;
//                } else if(temp >edge){
//                    return false;
//                }
//            }
//        }
//
//        return cnt==4?true:false;

        int sum = 0, edge = 0;
        for (int i = 0; i < matchsticks.length; i++) {
            sum += matchsticks[i];
        }
        if (sum % 4 != 0) {
            return false;
        } else {
            edge = sum / 4;
        }
        Arrays.sort(matchsticks);

        int [] edges = new int [4];

        return dfs(matchsticks.length-1,matchsticks,edges,edge);
    }

    private boolean dfs(int index, int[] matchsticks,int []edges, int len){
        if(index<0){
            return true;
        }
        for(int i = 0; i < 4; i++){
            edges[i] += matchsticks[index];
            if(edges[i]<=len && dfs(index -1 ,matchsticks,edges,len)){
                return true;
            }
            edges[i] -= matchsticks[index];
        }
        return false;
    }
    public static void main(String[] args) {
//        int a[] = {1,1,2,2,2};
//        makesquare(a);
    }
}
