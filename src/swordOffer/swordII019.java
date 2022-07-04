package swordOffer;
/**
剑指 Offer II 019. 最多删除一个字符得到回文
就是用双指针从两边检查
 */
public class swordII019 {
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        int len =  s.length();
        while (left < right) {
            if(s.charAt(left)!=s.charAt(right)){
                if(isPal(s.substring(0,left)+s.substring(left+1,len)) || isPal(s.substring(0,right)+s.substring(right+1,len))){
                    return true;
                }else{
                    return false;
                }
            }
            left++;
            right--;
        }
        return true;
    }
    private boolean isPal(String s){
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
