import java.util.Arrays;
import java.util.Comparator;

/**
 * 1710. 卡车上的最大单元数
 * 总的思路就是排序 Onlogn
 * 6ms 90%
 */
public class class1710 {
    public static void main(String[] args) {
        int [][] a ={{1,3},{2,2},{3,1}};
        class1710 test = new class1710();
        test.maximumUnits(a,4);
    }
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1]-o1[1];
            }
        });
        int max =0 ;
        for( int []Type:boxTypes){
            if(truckSize<=Type[0]){
                max += truckSize*Type[1];
            } else{
                max += Type[0]*Type[1];
            }
            truckSize-=Type[0];
            if(truckSize<=0){
                break;
            }
        }
        return max;
    }
}
