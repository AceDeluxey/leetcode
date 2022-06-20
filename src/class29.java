/**
 29. 两数相除
 思路：做不来，天天溢出超时
 */
public class class29 {
    public int divide(int dividend, int divisor) {
//        if(divisor==1){
//            return dividend;
//        }
//        if(dividend==-2147483648){
//            return 2147483647;
//        }
        int flag=1;
        if((dividend>0 && divisor<0) || (dividend<0 && divisor>0)){
            flag=-1;
        }
        long res=0;

        long dividend2 = Math.abs((long)dividend);
        divisor = Math.abs(divisor);
        while (dividend2>=divisor){
            dividend2 -= divisor;
            res ++;
        }
        System.out.println(flag*res>2147483647?2147483647: (int)(flag*res));
        return flag*res>2147483647?2147483647: (int)(flag*res);
    }
}
