/**
 * 735. 行星碰撞
 * 给定一个整数数组 asteroids，表示在同一行的行星。
 * 对于数组中的每一个元素，其绝对值表示行星的大小，正负表示行星的移动方向（正表示向右移动，负表示向左移动）。每一颗行星以相同的速度移动。
 * 找出碰撞后剩下的所有行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。
 *
 * 思路：栈
 * 学会了java可以break代码块
 * 98 58
 */
public class class735 {
    public int[] asteroidCollision(int[] asteroids) {
        int []stack=new int[asteroids.length];
        int top=0;
        for(int i=0;i<asteroids.length; i++){
            if(top==0){
                stack[top++]=asteroids[i];  //栈空入栈
            } else{
                collision:{
                    while( top!=0&&asteroids[i]<0 && stack[top-1]>0 ){//如果有相对的星球，开始遍历
                        if(stack[top-1]+asteroids[i] <0){           //相撞且右边大，continue继续循环
                            top--;
                            continue;
                        } else if (stack[top - 1] + asteroids[i] == 0) { //相撞消失，就不能入栈
                            top--;
                        }
                        break collision;    //如果相撞消失，或者撞了以后不撞不动左边了，才会运行这段break，也就不会入栈
                    }
                    stack[top++]=asteroids[i];  //不相撞才入栈
                }

            }
        }
        int []result=new int[top];
        for(int i=0;i<top;i++){
            result[i]=stack[i];
        }
        return result;
    }
}
//class735 test= new class735();
//        int []a={5,10,-6};
//        test.asteroidCollision(test.asteroidCollision(a));