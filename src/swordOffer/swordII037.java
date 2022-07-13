package swordOffer;

import java.util.Stack;

/**
 * 剑指 Offer II 037. 小行星碰撞
 * 用栈 但是感觉写多了好多特例判断 烦人
 * 11 ms 35%
 */
public class swordII037 {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int a : asteroids) {
            if (stack.isEmpty()) {
                stack.push(a);
            } else {
                if (a > 0) {
                    stack.push(a);
                } else {
                    int before = stack.peek();

                    if(before<0){
                        stack.push(a);
                        continue;
                    }

                    while (!stack.isEmpty() && before>0 && -1 * a > before) {
                        stack.pop();
                        before = stack.isEmpty() ? -1 : stack.peek();
                    }

                    if (!stack.isEmpty() ) {
                        if(stack.peek() < 0){
                            stack.push(a);
                        } else if(stack.peek() == -1*a){
                            stack.pop();
                        }
                    } else{
                        stack.push(a);
                    }
                }
            }
        }
        int[] res = new int[stack.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }
}
