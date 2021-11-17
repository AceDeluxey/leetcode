/**
 * 318. 最大单词长度乘积
 * 用整数进行状态压缩
 * 7ms
 */
public class class318 {

    public int maxProduct(String[] words) {
        //用int存储每个words的字母情况
        int mask [] = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            String temp = words[i];
            for(int j = 0; j <temp.length() ; j++){
                mask[i] |= 1<<(temp.charAt(j)-'a');
            }
        }
        int max = 0 ;
        for (int i = 0; i < words.length; i++) {
            for(int j=i+1; j < words.length; j++){
                if((mask[i] & mask[j])==0){
                    max = Math.max(words[i].length()*words[j].length() , max);
                }
            }
        }
        return max;
    }
}
