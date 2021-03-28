/**
 * 344. 反转字符串
 *  简单
 *  method1: 100 35
 *  但是怎么想都要使用到temp，增加内存
 *  method2: 本来想着靠加减法完成交换，虽然要强制类型转换，但可能节省空间
 *  没想到method2反而内存消耗变大了，说明强制类型转换还是比较耗费空间。
 */
public class class344 {
    public void reverseString(char[] s) {
        //method1
        for(int i=0;i<s.length/2; i++){
            char temp;
            temp=s[i];
            s[i]=s[s.length-1-i];
            s[s.length-1-i]=temp;
        }
    //method 2
//        for(int i=0;i<s.length/2; i++){
//            s[i]= (char) (s[i]+s[s.length-1-i]);
//            s[s.length-1-i]= (char) (s[i]-s[s.length-1-i]);
//            s[i]= (char) (s[i]-s[s.length-1-i]);
//        }
    }
}
