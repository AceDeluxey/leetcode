import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;
/**
    884. 两句话中的不常见单词
     * 给定两个句子A和B。（句子是一串由空格分隔的单词。每个单词仅由小写字母组成。）
     *
     * 如果一个单词在其中一个句子中只出现一次，在另一个句子中却没有出现，那么这个单词就是不常见的。
     *
     * 返回所有不常用单词的列表。

    思路：就是很简单的hashMap统计次数
        但是可以学到
        1.活用split可以分割出单词，但是要注意如果中间有多个空格就分割不了
        2.HashMap加入时，可以使用getorDefault,
            当map中没有该键值，获取自己设置的值，这里我们自己设0，那么当初次加入就0+;当Map中有，就获取对应值
            这样就不用写if else
        3.list转数组
            list相对于数组的好用之处在于，不用提前告知长度。
            转数组用 list.toArray(new Object),可以转换未不同的数组
 *

 */
public class class884 {
    public String[] uncommonFromSentences(String A, String B) {
        HashMap<String,Integer> map = new HashMap<>();
        for(String s:A.split(" ")){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        for(String s:B.split(" ")){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        List<String> list =new LinkedList<>();
        for(String word:map.keySet()){
            if(map.get(word)==1){
                list.add(word);
            }
        }
        return list.toArray(new String[list.size()]);
    }
}
