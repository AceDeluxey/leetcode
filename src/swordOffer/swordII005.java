package swordOffer;

/**
 * 剑指 Offer II 005. 单词长度的最大乘积
 * 9ns 50%
 *  On2
 *  用这个位运算还是很容易想到的
 *  还有就是继续优化 我没写
 *  可以用map存每个mask对应的最长的
 *  比如 eg eggggg egegegegegeg ，是同样的组成，存到map里
 *  本来要比较三次就缩短成了一次
 *  不过这样复杂度基本还是On2 除非大量的这种重复组成
 *  我就没有写
 *
 */
public class swordII005 {
    public int maxProduct(String[] words) {
        int[] mask = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int m = 0;
            for (int j = 0; j < word.length(); j++) {
                m |= 1 << word.charAt(j) - 'a';
            }
            mask[i] = m;
        }
        int res =0 ;
        for (int i = 0; i < mask.length; i++) {
            for (int j = 1 + 1; j < mask.length; j++) {
                if ((mask[i]&mask[j])==0){
                    res =Math.max(res, words[i].length()*words[j].length());
                }
            }
        }
        return res;
    }
}
