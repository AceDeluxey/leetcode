import java.util.Arrays;

/**
 * 2037. 使每位学生都有座位的最少移动次数
 * 其实就是排序，排完序，对应位置的座位就是最近的座位
 * 直觉上感觉是这样，实际上跑出来也是这样
 * 比如座位是1 2 3 ，人在 5 6 7
 * 肯定是5去1，6去2 7去3 总共12 ，最小
 * 贪心
 * 2ms 97%
 */
public class class2037 {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
//        int index1=0,index2=0;
        int res=0;
        for( int i =0 ; i <seats.length;i++){
            res+=Math.abs(seats[i]-students[i]);
        }
        return res;
    }
}
