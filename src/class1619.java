import java.util.Arrays;

/**
 *
 * 1619. 删除某些元素后的数组均值
 *
 * 本来想用小根堆 大根堆 但是也是Ologn
 * 如果能在排序里写出加和来的话 应该更快
 *
 * 2ms 98%
 */
public class class1619 {
    public double trimMean(int[] arr) {
        int len = arr.length;
        int n = (int) (len*0.05);
        Arrays.sort(arr);
        int sum = 0 ;
        for(int i = len/20; i< 19*len/20; i++){
            sum += arr[i];
        }
        return sum/(len*0.9);
    }
}
