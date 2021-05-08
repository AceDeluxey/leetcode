/*
    552. 学生出勤记录 II
    给定一个正整数 n，返回长度为 n 的所有可被视为可奖励的出勤记录的数量。
    答案可能非常大，你只需返回结果mod 109 + 7的值。
    如果记录不包含多于一个'A'（缺勤）或超过两个连续的'L'（迟到），则该记录被视为可奖励的。

    思路：DP，不过状态比较多，第n位的数量取决于n-1位每个状态的数量
        共有6个状态：0: 0A，0L ;1: 0A 1L;2:  0A 2L;3:  1A 0L;4:  1A 1L;5:  1A 2L;
        P可以乘在所有状态上
        A可以乘在前三个状态上
        L可以乘在0 1 3 4 四个状态上

        难点在于想到说只与前一个的状态有关，以及归纳出6个状态
        还有JAVA大数好容易溢出，必须加一次Mod一次


        258ms 30.4%;
 */

public class class552 {
    public int checkRecord(int n) {
        int mod=1000000007;
        long [] dp= {1,1,0,1,0,0};     //由于只与n-1有关，所以只用一个数组存上一次的dp就可以了
        for( int i=0 ;i <n-1 ;i++){
            long temp [] =new long[6];
            temp[0]=((dp[0]+dp[1])%mod+dp[2])%mod;    //0状态可以由 0 1 2+ P转移
            temp[1]=dp[0]%mod;         //1状态由1 + L构成
            temp[2]=dp[1]%mod;         //2状态由1转移
            //3由0 1 2+A 或者 3 4 5 +P 转移
            temp[3]= (((dp[0]+dp[5])%mod+(dp[1]+dp[4])%mod)%mod+(dp[2]+dp[3])%mod)%mod;
            temp[4] = dp[3]%mod;    //由3转移
            temp[5] = dp[4]%mod;   //由4转移
            dp=temp;
        }
        int  result=(int)(((dp[0]+dp[5])%mod+(dp[1]+dp[4])%mod)%mod+(dp[2]+dp[3])%mod)%mod;
        return  result;
    }

}
/*
    class552 test = new class552();
        System.out.println(test.checkRecord(2));
 */