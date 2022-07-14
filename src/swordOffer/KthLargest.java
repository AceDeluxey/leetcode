package swordOffer;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 剑指 Offer II 059. 数据流的第 K 大数值
 * 优先队列 优先队列实际上是小根堆， 每次poll的时候是poll最小值，所以只要维护k size 的优先队列 队列里就是k个最大值
 * 然后peek k个最大值里的最小值
 *
 *
 */
public class KthLargest {
    int k  ;
    PriorityQueue<Integer> que;
    public KthLargest(int k, int[] nums) {
        que = new PriorityQueue<>();
        for(int num:nums){
            add(num);
        }
    }

    public int add(int val) {
        que.offer(val);
        if(que.size()>k){
            que.poll();
        }
        return que.peek();
    }
}
