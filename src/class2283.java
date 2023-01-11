/**
 * 2283. 判断一个数的数字计数是否等于数位的值
 * 0ms 100%
 * 超出的不用管
 */
public class class2283 {
    public boolean digitCount(String num) {
        int len = num.length();
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            int index = num.charAt(i)-'0';
            if(index<len){
                nums[index] +=1;
            }
        }
        for( int i =0 ; i <len;i++){
            if(nums[i]!= num.charAt(i)-'0'){
                return false;
            }
        }
        return true;
    }
}
