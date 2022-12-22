/**
 * 1753. 移除石子的最大得分
 *其实是数学题
 * 0ms 100%
 * 贪心
 * 如果a+b<=c,就是拿a+b，另外的话就是sum/2，这个sum/2有点复杂
 *
 *
 */
public class class1753 {
    public int maximumScore(int a, int b, int c) {
        int sum = a + b + c;
        int maxVal = Math.max(Math.max(a, b), c);
        return Math.min(sum - maxVal, sum / 2);

    }
}
