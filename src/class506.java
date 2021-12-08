import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * 506. 相对名次
    思路：排序+哈希 比较简单 就是忘记了怎么覆写arrays.sort
 */
public class class506 {
    public String[] findRelativeRanks(int[] score) {
        HashMap<Integer,Integer> map  = new HashMap<>();
        for( int  i=0;i < score.length; i++){
            map.put(score[i],i);
        }
        Arrays.sort(score);

        String res [ ] =  new String [score.length];
        for(int i = score.length - 1; i >=0; i--){
            if(i==score.length - 1){
                res[map.get(score[i])] = "Gold Medal";
                continue;
            }
            if(i==score.length - 2){
                res[map.get(score[i])] = "Silver Medal";
                continue;
            }
            if(i==score.length - 3){
                res[map.get(score[i])] = "Bronze Medal";
                continue;
            }
            res[map.get(score[i])] = Integer.toString(score.length  -i);

        }
        return res;
    }
}
