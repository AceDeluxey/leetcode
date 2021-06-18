/**
 *  1227. 飞机座位分配概率
    有 n 位乘客即将登机，飞机正好有 n 个座位。第一位乘客的票丢了，他随便选了一个座位坐下。
    数学
 */
public class class1227 {
    public double nthPersonGetsNthSeat(int n) {
        return n==1?1:0.5;
    }
}
