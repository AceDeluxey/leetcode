import java.util.ArrayList;
import java.util.List;

/**
 * 1656. 设计有序流
 * 69ms  98%
 * 基本没啥东西 模拟一下
 */
public class OrderedStream {
    String stream [] ;
    int ptr = 0 ;
    public OrderedStream(int n) {
        stream = new String [n];
    }

    public List<String> insert(int idKey, String value) {
        stream[idKey-1] = value;
        List<String> res = new ArrayList<>();
        if(idKey-1 == ptr){
            while(ptr<stream.length && stream[ptr]!=null){
                res.add(stream[ptr]);
                ptr++;
            }
        } else{
            return res;
        }
        return res;
    }
}
