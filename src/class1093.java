import javafx.util.Pair;

/**
 * 1093. 大样本统计
 * 学到的median求法
 * 就是无论奇偶，中位数的左边和右边的长度一定相等，都等于(n−1)/2
 * 1ms 75%
 */
public class class1093 {
    public double[] sampleStats(int[] count) {
        int len = count.length;
        double min = -1 ;
        double max =0;
        long sum = 0;
        int cnt =0;
        // 众数和对应的数量
        Pair<Integer,Integer> mode= new Pair<>(0,0);
        double med =0 ;
        for( int i =0 ; i  <len;i++){
            int temp = count[i];
            if(temp!=0){

                if(min==-1){
                    min = i;
                }
                max = i ;
                sum+=(long)i*temp;
                cnt+=temp;
                if(mode.getValue()<temp){
                    mode = new Pair<>(i,temp);
                }


            }
        }
        double mean = (double) sum/cnt;
        int i =0 ,j =len-1;
        for( int m= (cnt-1)/2;m>=count[i];m -= count[i++]);
        for( int m= (cnt-1)/2;m>=count[j];m -= count[j--]);
        double median = (i+j)/2.0;
        return new double[]{min,max,mean,median,mode.getKey()};
    }
}
