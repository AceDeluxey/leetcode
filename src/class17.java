import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 *  给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。

   思路：DFS就行，不能一直使用for循环是因为不知道要写几个循环
         而且在DFS中，要拼接到最后才可以加入list，不能在返回出来的地方加，因为只可能返回出一种情况，所以不能满足

    1ms 87%
 */
public class class17 {
    HashMap<Character, String> map = new HashMap<>();
    List<String> result;

    public List<String> letterCombinations(String digits) {
        result = new LinkedList<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        if (digits == "" || digits == null || digits.length() == 0) {
            System.out.println("?");
            return new ArrayList<>();
        }
        DFS(digits, "", 0);

        return result;
    }

    private String DFS(String digits, String last, int index) {
        if (index >= digits.length()) {
            result.add(last);
            return "";
        }

        String alpha = map.get(digits.charAt(index));


        for (int i = 0; i < alpha.length(); i++) {

            String temp = Character.toString(alpha.charAt(i));

            DFS(digits, last + temp, index + 1);

        }
        return "";
    }
}
