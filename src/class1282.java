import java.util.List;
import java.util.ArrayList;
public class class1282 {
//    List<List<Integer>>
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
            List<List<Integer>> result=new ArrayList<List<Integer>> ();
            int len=groupSizes.length;
            int mem1=groupSizes[0];
            int con[]=new int[len];

            for(int i=0;i<len;i++){
                if (con[i]==0){
                    List res = new ArrayList<Integer>();
                    int index=0;
                    res.add(i);
                    index ++;
                    con[i]=1;
                    if(index==groupSizes[i]){
                        result.add(res);
                        continue;
                    }
                    for( int j=i+1;j<len;j++){
                        if(con[j]==0 && groupSizes[j]==groupSizes[i]){
                            res.add(j);
                            index++;
                            con[j]=1;
                            if(index==groupSizes[i]){
                                break;
                            }
                        }
                    }
                    result.add(res);

                }
            }
            return result;
        };
}
//    class1282 test=new class1282();
//        int a[] = {2,1,3,3,3,2};
//        System.out.println(test.groupThePeople(a));