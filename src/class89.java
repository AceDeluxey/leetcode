import javax.jnlp.ClipboardService;
import java.util.ArrayList;
import java.util.List;

/**
 * 89. 格雷编码
 * 思路：标准的dfs
 * 9ms 24.6%
 */
public class class89 {
    List<Integer> res;
    int len;
    boolean bool[];

    public List<Integer> grayCode(int n) {
        len = (int) Math.pow(2, n);
        res = new ArrayList<>();
        bool = new boolean[len];
        DFS( 0, n);
        return res;
    }

    boolean DFS( int index, int n) {
        if (index == len ) {
            return true;
        }
        if (index == 0) {
            res.add(0);
            bool[0] = true;
            DFS( index + 1, n);
        } else {
            int mask=1;
            int temp = res.get(index - 1 );
            for (int i = 0; i < n; i++) {
                int temp2 = temp^mask;
                if(!bool[temp2]){
                    res.add(temp2);
                    bool[temp2] = true;
                    if(DFS( index + 1, n)){
                        return true;
                    }
                    res.remove(index);
                    bool[temp2] = false;
                }
                mask = mask<<1;
            }
        }
        return false;
    }
}
