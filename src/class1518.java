// 1518. 换酒问题

/**
 * 小区便利店正在促销，用 numExchange 个空酒瓶可以兑换一瓶新酒。你购入了 numBottles 瓶酒。
 *
 * 如果喝掉了酒瓶中的酒，那么酒瓶就会变成空的。
 *
 * 请你计算 最多 能喝到多少瓶酒。
 * 思路:说是贪心，但我理解就是可以省略喝酒这个过程
 *     就一拿到酒它就是空瓶，然后sum+上每次兑换的空瓶即可
    时间100， 内存36
 */
public class class1518 {
    public int numWaterBottles(int numBottles, int numExchange) {
        int sum=numBottles;

        while(numBottles>=numExchange){
            sum+=numBottles/numExchange;
            numBottles=numBottles%numExchange+numBottles/numExchange; //空瓶数量
        }
        return sum;
    }
}
