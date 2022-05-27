package Interview;

/**
 * 面试题 17.11. 单词距离
 * 直觉来说 就遍历 不断记录两个单词的位置 然后每次遍历取最小就好了 实事也是这样
 *
 *  0n  12ms 59%
 */
public class interview1711 {
    public int findClosest(String[] words, String word1, String word2) {
        //两个单词的index
        int index1=-1,index2=-1;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if(words[i].equals(word1)){
                index1=i;
            }
            if(words[i].equals(word2)){
                index2=i;
            }
            if(index1!=-1 && index2 != -1){
                res = Math.min(res,Math.abs(index1-index2));
            }

        }
        return res;
    }
}
