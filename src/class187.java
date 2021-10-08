import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
    187. 重复的DNA序列
        所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。
        在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。

    思路：就是顺序把String 放到map里，虽然是O(n),但是长度为10的key时间代价太大
        如果能用O1复杂度的hash函数把String给hash后再放map会好一些
        也有答案是这样的

        22ms 27%

 */
public class class187 {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String temp = s.substring(i, i + 10);
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= 2) {
                res.add(entry.getKey());
            }
        }
        return res;
    }
}
