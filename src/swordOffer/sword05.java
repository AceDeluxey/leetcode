package swordOffer;

/**
 * 剑指 Offer 05. 替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * 思路: java写这个就很简单
 *      0ms 100; 36.4 M 36
 */
public class sword05 {
    public String replaceSpace(String s) {
        StringBuffer buffer=new StringBuffer();
        for(int i=0;i<s.length(); i++){
            if(s.charAt(i)!=' '){
                buffer.append(s.charAt(i));
            } else{
                buffer.append("%20");
            }
        }
        return buffer.toString();
    }
}
