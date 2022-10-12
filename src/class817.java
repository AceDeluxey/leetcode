import DataStructure.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 817. 链表组件
 * 依次遍历 On 76
 */
public class class817 {
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums){
            set.add(num);
        }
        int res=0;
        Boolean flag = false;
        while(head!=null){
            if(set.contains(head.val)){
                if(!flag){
                    res++;
                    flag=true;
                }
            }else{
                flag=false;
            }
            head =head.next;
        }
        return res;
    }
}
