/**
 * 953. 验证外星语词典
 * 分情况讨论就可以了，本来以为indexof会慢 没想到还是 0ms 100%
 */
public class class953 {
    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 1; i < words.length; i++) {
            if (!cp(words[i - 1], words[i], order)) {
                return false;
            }
        }
        return true;
    }

    //判断相邻两个字符串是不是符合字典序
    private static boolean cp(String word1, String word2, String order) {
        int index1 = 0, index2 = 0, len1 = word1.length(), len2 = word2.length();
        //判断两个字符串前缀是不是一样
        if (len1 > len2) {
            if (word1.substring(0,len2).equals(word2)){
                return false;
            }
        }

        for (; index1 < word1.length() && index2 < word2.length();index1++,index2++ ) {
            //可以不用indexOf ,两个一起找，应该会更快
            int loc1 = order.indexOf(word1.charAt(index1));
            int loc2 = order.indexOf(word2.charAt(index2));
            if(loc1>loc2){
                return false;
            } else if( loc1<loc2){
                return true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String word1="apple",word2="app";
        String order="hlabcdefgijkmnopqrstuvwxyz";
        cp(word1,word2,order);
    }
}
