import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
    496. 下一个更大元素 I
    思路：对于一个数组，怎么找到每一个元素右边的最大元素
        可以从左到右维护一个单调栈，遍历中栈里永远是上面最大，下面最小；
        对于遍历的每一个元素，如果其比栈顶大，说明栈顶不是右边的最大出栈，如果没有栈顶大，说明右边最近的大元素就是栈顶
        所以用先遍历出一个单调栈，就可以方便的找到下一个更大元素
    O(m+n)  4ms 46%
 */
public class class496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=nums2.length - 1; i >= 0; i--){
            while(!stack.isEmpty() && nums2[i]>stack.peek()){
                stack.pop();
            }
            map.put(nums2[i],stack.isEmpty()?-1: stack.peek());
            stack.push(nums2[i]);
        }

        for( int i=0; i<nums1.length; i++){
            nums1[i]= map.get(nums1[i]);
        }
        return nums1;
        /**
         * 理解错了
         */
//        //nums2 i位置右边的最大值
//        int max = nums2[nums2.length - 1];
//        for (int i = nums2.length - 1; i >= 0; i--) {
//            int temp = nums2[i];
//            if(i==nums2.length - 1){
//                nums2[i]=0;
//            } else{
//                nums2[i] = max;
//            }
//            max= Math.max(temp,max);
//        }
//
//        //在nums1中比较
//        for(int i=0; i< nums1.length;i++){
//            if(nums1[i]< nums2[i]){
//                nums1
//            }
//        }
    }
}
