import java.util.Stack;

/**
 * 1006. 笨阶乘
 * 通常，正整数 n 的阶乘是所有小于或等于 n 的正整数的乘积。例如，factorial(10) = 10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1。
 *
 * 相反，我们设计了一个笨阶乘 clumsy：在整数的递减序列中，我们以一个固定顺序的操作符序列来依次替换原有的乘法操作符：乘法(*)，除法(/)，加法(+)和减法(-)。
 *
 * 思路： 由于/*要先运算，所以直接运算再入栈就好
 * 因为+的后面不是 乘除
 * -后面是乘除，所以要单独入栈
 *
 * 9%  18% 没有硬解效率高
 * */


public class class1006 {
    public int clumsy(int N) {
        if(N==1 ||N==0){
            return N;
        }
        int cnt=1;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(N);
        for(int i=N-1;i>=1;i=N-cnt){
            if(cnt%4 ==1){
                stack.push(stack.pop()*i);
            } else if(cnt%4==2){
                stack.push(stack.pop()/i);
            } else if(cnt%4==3){
                stack.push(i+ stack.pop());
            } else{
                stack.push(-i);
            }
            cnt++;
        }
        int ret=0;
        while(!stack.isEmpty()){
            ret+= stack.pop();
        }
        return ret;
    }
}
//class1006 test=new class1006();
//        System.out.println(test.clumsy(10));