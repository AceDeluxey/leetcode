import java.util.LinkedList;
import java.util.List;


/**
 * 118. 杨辉三角
     给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
     在「杨辉三角」中，每个数是它左上方和右上方的数的和。

    简单
    0ms 100%
 */
public class class118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> temp = new LinkedList<>();
            if (i == 0) {
                temp.add(1);
            }  else {
                temp.add(1);
                for (int j = 0; j < i - 1; j++) {
                    List<Integer> last = result.get(result.size() - 1);
                    temp.add(last.get(j)+ last.get(j+1));
                }
                temp.add(1);
            }
            result.add(temp);
        }
        return result;
    }
}
