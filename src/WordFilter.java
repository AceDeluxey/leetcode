/**
 * 745. 前缀和后缀搜索
 * 没写完  太困难了
 * 要写两个trie 然后还要在trie里写index的list
 *
 */
public class WordFilter {
    class Trie {
        Boolean isEnd;
        int index;
        Trie[][] list;

        public Trie() {
            this.isEnd = false;
            list = new Trie[26][26];
        }
    }

    Trie root;

    public WordFilter(String[] words) {
        root = new Trie();
        Trie node = root;
        for (String word : words) {

            int left = 0, right = words.length - 1;
            while (left < words.length) {
                int index1 = word.charAt(left)-'a';
                int index2 = word.charAt(right)-'a';
                if (node.list[index1][index2]==null){
                    node.list[index1][index2] = new Trie();
                }
                node = node.list[index1][index2];
            }
        }
        node.isEnd =true;
    }

    public int f(String pref, String suff) {
        return 1;
    }
}
