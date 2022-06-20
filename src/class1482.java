
    /*
        1482. 制作 m 束花所需的最少天数
        给你一个整数数组 bloomDay，以及两个整数 m 和 k 。
        花园中有 n 朵花，第 i 朵花会在 bloomDay[i] 时盛开，恰好 可以用于 一束 花中。
        请你返回从花园中摘 m 束花需要等待的最少的天数。如果不能摘到 m 束花则返回 -1 。

        2021.5.9 想了一下没想出来，看答案要用二分查找不想学，以后再学
     */

public class class1482 {
    public int minDays(int[] bloomDay, int m, int k) {
        int len=bloomDay.length;
        if(len<m*k){
            return -1;
        }
        for( int i =0; i < m ; i++){

        }
        return 1;
    }
}
