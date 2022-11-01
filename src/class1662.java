/**
 * 1662. 检查两个字符串数组是否相等
 * 果然用StringBuffer在FOR里面就快很多 0ms 100%
 */
public class class1662 {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        for(int i =0;i<word1.length;i++){
            sb1.append(word1[i]);
        }
        for(int i =0;i<word2.length;i++){
            sb2.append(word2[i]);
        }
        return sb1.toString().equals(sb2.toString());
    }
}
