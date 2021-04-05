package swordOffer;
/**
 * 剑指 Offer 58 - I. 翻转单词顺序
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 *
    思路：双指针倒序遍历，难度不大
    69% 23%
 */

public class Offer58I {
    public String reverseWords(String s) {
        s=s.trim();
        StringBuffer buffer = new StringBuffer(s.length());
        int index2=s.length()-1,i=index2;
        while(i>=0) {
            while (i >= 0 && s.charAt(i) != ' ') {   //找到每个单词开始的字母
                i--;
            }
            buffer.append(s.substring(i + 1, index2 + 1)); //获取单词
            while (i >= 0 && s.charAt(i) == ' ') {  //跳过单词间的空格
                i--;
            }
            buffer.append(' ');
            index2 = i;   //指向新的单词的结尾
//            buffer.append(s.charAt(i));
        }
        return buffer.toString().trim();
    }
}
