/**
 * 520. 检测大写字母
 *
 * 1MS 98%
 */
public class class520 {
    public boolean detectCapitalUse(String word) {
        if (word.length() <= 1) {
            return true;
        }
        if (word.charAt(0) >= 'A' && word.charAt(0) <= 'Z') {
            //1表示小写，2表示大写
            boolean flag1 = true, flag2 = true;
            for (int i = 1; i < word.length(); i++) {
                if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z'){
                    flag1 = false;
                } else{
                    flag2 = false;
                }
            }
            if(flag1 || flag2){
                return true;
            }
        } else{
            for (int i = 1; i < word.length(); i++) {
                if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z'){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
