import java.util.Arrays;

/**
 * 1996. 游戏中弱角色的数量
 *  排序，主要是兼顾两列的排序
 *  106ms 17%  nlogn
 */
public class class1996 {
    public int numberOfWeakCharacters(int[][] properties) {
        int res = 0 ;
        int max = 0;
        // 把数据按照一组从大到小排列， 第一列相同时，对第二列从小到大；因为可能有攻击一样，防御不一样的，如果这时不对第二列排序，就有可能出错
        Arrays.sort(properties, (o1,o2)->{
            return o1[0]==o2[0]?o1[1]-o2[1]:o2[0]-o1[0];
        });
        for(int [] temp :properties){
            if(temp[1]<max){
                res++;
            } else{
                max = temp[1];
            }
        }
        return  res;
    }
}
