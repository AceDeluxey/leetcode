/**
 * 1832. 判断句子是否为全字母句
 * 位运算
 * 2ms 59
 */
public class class1832 {
    public boolean checkIfPangram(String sentence) {
        int mask = 0;
        for (int i = 0; i < sentence.length(); i++) {
            int temp = sentence.charAt(i)-'a';
            mask = mask | (1<<temp);
        }

        //记得可以用十六进制，8421码写，不用1111这样哈哈哈哈哈
        return mask==0x3ffffff ;
    }
}
