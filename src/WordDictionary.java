import java.util.HashSet;
import java.util.Set;

public class WordDictionary {
    Set<String> set ;
    public WordDictionary() {
        set = new HashSet<>();
    }

    public void addWord(String word) {
        set.add(word);
    }

    public boolean search(String word) {
        return set.contains(word);
    }
}
