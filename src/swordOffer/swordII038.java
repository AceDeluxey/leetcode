package swordOffer;

import java.util.Stack;

/**
 * 剑指 Offer II 038. 每日温度
 * 单调栈，每个元素只用入栈一次 出战一次
 * 实际上只是用了栈来存储，用List存储效果也是一样的，这样处理自然时从大到小排列，
 * 实质的思想是 将还没找到更大值的元素存储在一个结构中， 遇到大的就睡着去比 然后入栈，存储的同时要存index
 * 168ms 27%
 */
public class swordII038 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        //在入栈时  要记录数字对应的index 否则算不出天数
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            if (stack.isEmpty()) {
                stack.push(new int[]{temperatures[i], i});
            } else {
                while (!stack.isEmpty() && stack.peek()[0] < temperatures[i]) {
                    int[] temp = stack.pop();
                    res[temp[1]] = i - temp[1];
                }
                stack.push(new int[]{temperatures[i], i});
            }
        }
        while(!stack.isEmpty()){
            int[] temp = stack.pop();
            res[temp[1]] = 0;
        }
        return res;
    }
}
