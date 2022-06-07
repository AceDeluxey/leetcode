/**
 * 58. 最后一个单词的长度
 * 简单的很
 */
public class class58 {
    public int lengthOfLastWord(String s) {
        String [] list = s.split(" ");
        return list[list.length - 1].length();
    }
}
