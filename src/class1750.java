/**
 * 1750. 删除字符串两端相同字符后的最短长度
 * 其实不难 达不到中等，就是边界条件 left和right怎么重合结束要注意一下
 *
 * 3ms 100%
 */
public class class1750 {
    public int minimumLength(String s) {
        int left =0,right=s.length()-1;
        while(left<right){
            if(s.charAt(left)==s.charAt(right)){
                char c=s.charAt(left);
                while(left<right && s.charAt(left)==c){
                    left++;
                }
                while(left<right && s.charAt(right)==c){
                    right--;
                }
            }
        }
        return right-left<0?0:right-left;
    }
}
