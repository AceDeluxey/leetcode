import java.util.*;

/**
     575. 分糖果
    思路：其实是数学题，有m种糖给一个人分n颗，如果m>n，只能分到最多n种；如果m<n，则最多分m种

    On 32ms 90%
 */
public class class575 {
    public int distributeCandies(int[] candyType) {
        //有几种糖
        Set<Integer> set = new HashSet<>();

        for(int e: candyType){
            set.add(e);
        }


        return candyType.length/2<set.size() ? candyType.length/2: set.size();
    }
}
