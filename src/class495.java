/**
 * 495. 提莫攻击
 *
    简单 没啥说的 2ms 90%
 */

public class class495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int end = 0 ;
        int res=0;
        for (int i = 0; i < timeSeries.length; i++) {
            //上一次结束了
            if(timeSeries[i] >=end){
                end = timeSeries[i]+duration;
                res += duration;
            } else if(timeSeries[i] +duration >end){
                //上一次还没结束，延时
                res+= timeSeries[i]+duration - end;
                end = timeSeries[i]+duration;
            }

        }

        return res;
    }
}
