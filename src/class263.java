/*
    263. 丑数
    给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。

    丑数 就是只包含质因数2、3 和/或5的正整数。

    1ms 100%
 */
public class class263 {
    public boolean isUgly(int n) {
        if(n==0){
            return false;
        }
        while(n%2==0){
            n /=2;
        }
        while(n%3==0){
            n /=3;
        }
        while(n%5==0){
            n /=5;
        }
        if(n==1){
            return true;
        }
        return false;
    }
}
