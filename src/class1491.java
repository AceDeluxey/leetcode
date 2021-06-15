/**
    1491. 去掉最低工资和最高工资后的工资平均值
    思路：简单
    0ms 100%
 */
public class class1491 {
    public double average(int[] salary) {
        int sum=0,max=0,min=Integer.MAX_VALUE,len= salary.length;
        if(len==1){
            return salary[0];
        }
        for ( int i=0 ; i<len ;i++){
            sum+=salary[i];
            max=Math.max(max, salary[i]);
            min=Math.min(min,salary[i]);
        }
        return (double) (sum-max-min)/(len-2);
    }
}
