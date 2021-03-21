import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;
public class class136 {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i< nums.length;i++){
            if(!set.add(nums[i])) {
                set.remove(nums[i]);
            }
        }
        Iterator it= set.iterator();
//        System.out.println(it.next());
        return (int) it.next();
    }
}
