import java.util.Stack;

/**
 * 1053. 交换一次的先前排列
 * 给你一个正整数数组 arr（可能存在重复的元素），请你返回可在 一次交换（交换两数字 arr[i] 和 arr[j] 的位置）后得到的、按字典序排列小于 arr 的最大排列。
 *
 *
 *写的有问题，佛了不想改了
 *
 *
 */
public class clas1053 {
    public static void main(String[] args) {
        clas1053 test = new clas1053();
        int [] arr = {3,2,1};
        test.prevPermOpt1(arr);
    }
    public int[] prevPermOpt1(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for( int i =0 ; i < arr.length;i++){

            int temp = arr[i];

            while(!stack.isEmpty() && temp>arr[stack.peek()]){
                stack.pop();
            }
            stack.push(i);

        }
        if(stack.size()>=2){
            int index1 =stack.pop();
            int index2 = stack.pop();
            int t = arr[index2];
            arr[index2] = arr[index1];
            arr[index1] = t;
            return  arr;
        }
        return arr;
    }
}
