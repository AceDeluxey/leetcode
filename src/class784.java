import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * 784. 字母大小写全排列
 * 7ms 就dfs就好了
 */
public class class784 {
    public static void main(String[] args) {
        String s = "a1b2";
        class784 test = new class784();
        test.letterCasePermutation(s);
    }
    List<String> res;

    public List<String> letterCasePermutation(String s) {
        res = new ArrayList<>();
        DFS(s, "", 0);
        return res;
    }

    private void DFS(String s, String temp, int index) {
        if (index >= s.length()) {
            res.add(temp);
            return;
        } else {
            char c = s.charAt(index);
            if (isCapital(c)||isSmall(c)){
                DFS(s,temp+String.valueOf(c).toLowerCase(),index+1);
                DFS(s,temp+String.valueOf(c).toUpperCase(),index+1);
            }else{
                DFS(s,temp+c,index+1);
            }
        }
    }

    private boolean isCapital(char c) {
        if (c >= 'A' && c <= 'Z') {
            return true;
        } else {
            return false;
        }
    }

    private boolean isSmall(char c) {
        if (c >= 'a' && c <= 'z') {
            return true;
        } else {
            return false;
        }
    }
}
