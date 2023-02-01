import java.util.HashMap;
import java.util.Map;

/**
 * 2325. 解密消息
 * 还是有点繁杂
 * 7ms 40%
 */
public class class2325 {
    public static void main(String[] args) {
        class2325 test = new class2325();
        test.decodeMessage("the quick brown fox jumps over the lazy dog",
                "vkbs bs t suepuv");
    }
    public String decodeMessage(String key, String message) {
        boolean app[] = new boolean[26];
        Map<Integer, Integer> map = new HashMap<>();
        int tableIndex = 0;
        for (int i =0 ;i<key.length();i++) {
            if(key.charAt(0)==' '){
                continue;
            }
            int index = key.charAt(i)-'a';
            if (!app[index]) {
                map.put(index, tableIndex++);
                app[index] = true;
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if(c==' '){
                sb.append(' ');
                continue;
            }
            int index = c-'a';
            char ele= map.containsKey(index)? (char) (map.get(index) + 'a') :c;
            sb.append(ele);
        }
        return sb.toString();
    }
}
