import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 139. 单词拆分
 * 虽然说是什么动态规划。01背包
 * 可是朴素的想法也应该是这样的，没什么难以想象的
 * 就是先转化为set,再On2判断就可以了
 * 8ms 32.8%
 */
public class class139 {
    public static void main(String[] args) {
        class139 test = new class139();
        List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        test.wordBreak("leetcode", list );
        String s ="abcd";
        System.out.println(s.substring(1,3));
   }
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean dp[] = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < s.length(); i++) {
            for( int j=i+1;j<=s.length();j++){
                if(!dp[j]){
                    dp[j] = dp[i]?set.contains(s.substring(i,j)):false;
                }

            }
        }
        return dp[s.length()];
    }
}
