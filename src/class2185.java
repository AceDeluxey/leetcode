/**
 * 2185. 统计包含给定前缀的字符串
 * 0ms 100%
 */
public class class2185
{
    public int prefixCount(String[] words, String pref) {
        int cnt =0 ;
        for(String word :words){
            if(isEq(pref,word)){
                cnt++;
            }
        }
        return cnt;
    }
    private boolean isEq(String prefix,String word){
        if(prefix.length()>word.length()){
            return false;
        }
        for(int i =0 ;i<prefix.length();i++){
            if(prefix.charAt(i)!=word.charAt(i)){
                return false;
            }
        }
        return true;
    }
}
