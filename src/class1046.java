import java.util.ArrayList;
import java.util.Collections;

/**
 *      1046. 最后一块石头的重量
 *      有一堆石头，每块石头的重量都是正整数。
 *      最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 *
 *      思路：排序，然后删除，排序，还是归功于封装的排序算法复杂度低
 *          2ms 54%
 *
 */
public class class1046 {
    public int lastStoneWeight(int[] stones) {
        ArrayList<Integer> list = new ArrayList<>();
        for( int i=0 ;i< stones.length ;i++){
            list.add(stones[i]);
        }
        Collections.sort(list);
        for( int i=stones.length - 1; i >= 1; i-=2){
            int big1=list.get(i);
            int big2=list.get(i-1);
            if(big1==big2){
                list.remove(i);
                list.remove(i-1);
            } else if( big1>big2 ){
                list.remove(i);
                list.remove(i-1);
                i++;
                list.add(big1-big2);
            }

            Collections.sort(list);
        }
        if(list.size()==0){
            return 0;
        } else{
            return list.get(0);
        }
    }
}
