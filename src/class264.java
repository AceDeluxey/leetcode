/*
    264. 丑数 II
    给你一个整数 n ，请你找出并返回第 n 个 丑数 。
    丑数 就是只包含质因数 2、3 和/或 5 的正整数

    思路： 暴力会超时，500/596 输入1352
 */
public class class264 {
    public int nthUglyNumber(int n) {
        int cnt=0;
        for( int i=1;  ;i++ ){
            if (isUgly(i)) {
                cnt ++;
            }
            if(cnt == n){
                return i;
            }
        }

    }
    public boolean isUgly(int n) {
        if(n==0){
            return false;
        }
        if(n==1){
            return true;
        }
        if(n%2!=0 && n%3!=0 && n%5!=0){
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
