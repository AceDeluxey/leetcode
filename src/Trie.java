/**
 * 208. 实现 Trie (前缀树)
 * 34 ms
 * , 在所有 Java 提交中击败了
 * 52.57%
 * 的用户
 * 还是用树形结构比较清晰 用数组结构不太好写
 */
public class Trie {
    class TrieNode {
        Boolean isEnd = false;
        TrieNode list [] = new TrieNode[26];
    }

    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode p = root;
        for(int i =0 ; i <  word.length();i++) {
            int num = word.charAt(i)-'a';
            if(p.list[num]==null){
                p.list[num] = new TrieNode();
            }
            p = p.list[num];
        }
        //结束一个词
        p.isEnd=true;
    }

    public boolean search(String word) {
        TrieNode p = root;
        for(int i =0 ; i <  word.length();i++) {
            int num = word.charAt(i)-'a';
            if(p.list[num]==null){
                //孩子中找不到这个字母 说明断了 没有这个单词
                return false;
            }
            p = p.list[num];
        }
        return p.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode p = root;
        for(int i =0 ; i <  prefix.length();i++) {
            int num = prefix.charAt(i)-'a';
            if(p.list[num]==null){
                //孩子中找不到这个字母 说明断了 没有这个单词
                return false;
            }
            p = p.list[num];
        }
        return true;
    }
}
