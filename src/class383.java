import java.util.jar.Pack200;


/**
 *      383. 赎金信
            给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。如果可以构成，返回 true ；否则返回 false。

        思路：在条件固定的情况下，可以用数组代替哈希表，速度会快很多
             1ms 99%
 */
public class class383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] alph = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            alph[magazine.charAt(i) - 'a'] ++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (alph[ransomNote.charAt(i) - 'a'] == 0) {
                return false;
            } else{
                alph[ransomNote.charAt(i) - 'a']--;
            }
        }
        return true;
    }
}
