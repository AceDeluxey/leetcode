import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class CustomFunction {
    int f(int x,int y){
        return 1;
    }
}

/**
 * 1237. 找出给定方程的正整数解
 * 二分查找
 * 但是还是Onlogn 所以还是很慢
 * 学会一种初始化list的方法，Arrays,aslist 静态方法，不过要注意这样生成的list不能扩展，所以只能静态使用
 * 还有就是见下面的匿名内部类，好像确实没有直接初始化的方法
 * 277ms 5%
 */
public class class1237 {
    List<String> names = new ArrayList<String>() {{
        add("Tom");
        add("Sally");
        add("John");
    }};
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            int left = 1, right = 1000;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (customfunction.f(i,mid)==z){
                    res.add(Arrays.asList(i,mid));
                    break;
                } else  if(customfunction.f(i,mid)<z){
                    left ++;
                } else{
                    right--;
                }
            }

        }
        return res;
    }
}
