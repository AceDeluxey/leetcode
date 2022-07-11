import java.util.ArrayList;
import java.util.List;

/**
 * 676. 实现一个魔法字典
 * 用Trie实现的 但是我没用到dfs 用来循环不知道是不是写复杂了  但是有点复杂不想看了
 * 37 ms 41%
 */
public class MagicDictionary {
    class Trie {
        Boolean isEnd = false;
        Trie[] list = new Trie[26];
    }

    Trie root;

    public MagicDictionary() {
        root = new Trie();
    }

    public void buildDict(String[] dictionary) {

        for (String s : dictionary) {
            Trie node = root;
            for (int i = 0; i < s.length(); i++) {
                int index = s.charAt(i) - 'a';
                if (node.list[index] == null) {
                    node.list[index] = new Trie();
                }
                node = node.list[index];
            }
            node.isEnd = true;
        }

    }

    private boolean searchSame(String s , Trie n){
        Trie node = n;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (node.list[index] != null) {
                node = node.list[index];
            } else{
                return false;
            }
        }
        return node.isEnd;
    }
    public boolean search(String searchWord) {
        //替换次数
        int num = 1;
        Trie node = root;
        for (int i = 0; i < searchWord.length(); i++) {

            int index = searchWord.charAt(i) - 'a';
            String s = searchWord.substring(i+1);

            for( int k=0;k<26;k++){
                if(k!= index && node.list[k]!= null && searchSame(s,node.list[k])){
                    return true;
                }
            }


            if (node.list[index] != null) {
                node = node.list[index];
            } else{
                //上面k循环中已经蕴含了 没有index对应node的情况，所以如果上面没找到 下面index又没有  说明直接false了
                return false;
            }
        }
        return false;
    }
}
