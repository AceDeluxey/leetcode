import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 1807. 替换字符串中的括号内容
 * 就暴力
 * 31ms  89.4%
 */
public class class1807 {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for (List<String> list:knowledge){
            map.put(list.get(0),list.get(1));
        }
        int index=0;
        StringBuilder sb = new StringBuilder();
        while(index<s.length()){
            char c =s.charAt(index);
            if(c!='('){
                sb.append(c);
                index++;
            } else{
                int tmp = index;
                while(s.charAt(index)!=')'){
                    index++;
                }
                String key = s.substring(tmp+1,index);
                sb.append(map.getOrDefault(key,"?"));
                index++;
            }
        }
        return sb.toString();
    }
}
