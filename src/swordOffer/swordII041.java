package swordOffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer II 041. 滑动窗口的平均值
 * 39ms 34.8
 */
public class swordII041 {
    int  sum;
    int size ;
    Queue<Integer> que;
    /**
     * Initialize your data structure here.
     */
    public MovingAverage(int size) {
        sum = 0;
        this.size = size;
        que = new LinkedList<Integer>();

    }

    public double next(int val) {
        double ave;
        if(que.size()<size){

        } else{
            sum -= que.poll();
        }
        sum+=val;
        que.offer(val);
        ave = (double)sum/que.size();
        return ave;
    }
}
