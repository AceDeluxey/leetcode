import java.util.Arrays;

/**
 * 2335. 装满杯子需要的最短总时长
 * 1ms 78
 * 就是贪心加分情况讨论
 */
public class class2335 {
    public int fillCups(int[] amount) {
        Arrays.sort(amount);
        if(amount[0]+amount[1]<amount[2]){
            return amount[2];
        }else {
            return (amount[0]+amount[1]+amount[2]+1)/2;
        }
    }
}
