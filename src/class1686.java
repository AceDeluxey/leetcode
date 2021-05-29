import  java.util.Arrays;
import java.util.Comparator;

/*
    1686. 石子游戏 VI
    Alice 和 Bob 轮流玩一个游戏，Alice 先手。
    一堆石子里总共有 n 个石子，轮到某个玩家时，他可以 移出 一个石子并得到这个石子的价值。Alice 和 Bob 对石子价值有 不一样的的评判标准 。双方都知道对方的评判标准。
    给你两个长度为 n 的整数数组 aliceValues 和 bobValues 。aliceValues[i] 和 bobValues[i] 分别表示 Alice 和 Bob 认为第 i 个石子的价值。
    所有石子都被取完后，得分较高的人为胜者。如果两个玩家得分相同，那么为平局。两位玩家都会采用 最优策略 进行游戏。

    思路： 贪心，对于玩家而言，一堆石头有两个价值，怎样最优？我拿石头，本质上是拿了这个石头对我的价值，和减去对对方的价值
              比如对于我的价值为1,但是对对方价值为100，其实对于我来说我拿它可以赚101，因为我让对方拿不到100
              所以按照这样的假设，我们一直贪，一直损人利己，可能就可以取得最优。
          所以我们把两个人的价值数组相加然后排序，顺着拿相加大的石头，最后就是最优解。
          在这样的假设下，最后果然是最优解。

     结果：代码一次通过，时间复杂度是sort排序的Onlogn
            110ms 82.6%
 */
public class class1686 {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int dif[][]= new int [aliceValues.length][2];
        for( int i=0 ;i<aliceValues.length; i++){
          dif[i][0] = aliceValues[i]+bobValues[i];
          dif[i][1] = i;
        }
        Arrays.sort(dif, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0]-o1[0];
            }
        });
        int sumAlice=0,sumBob=0;
        for(int i=0;i<aliceValues.length;i++){
            if(i%2==0){
                sumAlice +=aliceValues[dif[i][1]];
            } else{
                sumBob += bobValues[dif[i][1]];
            }
        }
        if(sumAlice == sumBob){
            return 0;
        } else if(sumAlice > sumBob){
            return  1;
        } else{
            return -1;
        }
    }
}
