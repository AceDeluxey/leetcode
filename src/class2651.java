/**
 * 2651. 计算列车到站时间
 * 0MS 100%
 */
public class class2651 {
    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        return (arrivalTime + delayedTime) %24;
    }
}
