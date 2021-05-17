import java.util.Arrays;
import java.util.Comparator;

    /*
        1029. 两地调度
        公司计划面试 2N 人。第 i 人飞往 A 市的费用为 costs[i][0]，飞往 B 市的费用为 costs[i][1]。
        返回将每个人都飞到某座城市的最低费用，要求每个城市都有 N 人抵达。

        思路：本来想用dp，但是想了一会也没想出怎么写
                贪心的话，首先选N个人飞去A，肯定想到的就是选的这个人A花的钱相较于B越少越好
                也就是将数组按照costs[i][1]-costs[i][0]排序，那么前一半肯定是飞A要比飞B划算
                我们直接选取前一半飞A。么剩下一般中虽然也可能存在A划算的，但肯定不如前一半划算了，只能把它们飞向B

            然后就是实现，学到了Arrays.sort方法，可以覆写比较器new Comparator<int[]>()
                sort方法中的compare对于int []，传入的是两个int ，比如int a,int b,是相邻像个整数，初始升序是返回a-b,根据正负判断排序
                那么我们想要反序，就可以直接rerturn b-a;
                如果排序int [][] ,那么传入的就是两行 int []a int []b,要写升序也还是return a[i]-b[i]这样
            那么我们就可以根据costs[i][1]-costs[i][0]排序
            排完序+就好了

            封装的sort时间复杂度是nlogn，所以总体也是nlogn

         2ms 72.9%

     */
public class class1029 {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, new Comparator<int[]>() {
            public int compare(int[]a,int[]b){
                return a[0]-a[1]-(b[0]-b[1]);
            }
        });
        int sum=0;
        int i=0;
        for( ;i< costs.length/2;i++){
            sum +=costs[i][0];
        }
        for( ;i< costs.length;i++){
            sum +=costs[i][1];
        }
        return sum;
    }
}
