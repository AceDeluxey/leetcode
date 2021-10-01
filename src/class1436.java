import java.util.HashSet;
import java.util.List;

/**
    1436. 旅行终点站
        给你一份旅游线路图,请你找出这次旅行的终点站

    思路：把起点存到set里，再循环验证终点在不在，不在就是所有的终点

        On   2ms 94%
 */
public class class1436 {
    public String destCity(List<List<String>> paths) {
        HashSet<String> set = new HashSet<>();
        for (List<String> path : paths) {
            set.add(path.get(0));
        }
        for (List<String> path : paths) {
            if (!set.contains(path.get(1))) {
                return path.get(1);
            }
        }
        return "";
    }

}
