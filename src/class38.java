/**
    38. 外观数列
 给定一个正整数 n ，输出外观数列的第 n 项。

    思路：就是暴力循环，没有什么简便方法除了打表
 2ms 67%

 */

public class class38 {
    public String countAndSay(int n) {
        String s = "1";
        for (int i = 0; i < n-1; i++) {
            s = count(s);
        }
        return s;
    }

    private String count(String s) {
        int start = 0 ;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)!=s.charAt(start)  ){
                sb.append(i-start).append(s.charAt(start));
                start = i;
            }
            //处理结尾的串
            if(i==s.length()-1){
                sb.append(i-start+1).append(s.charAt(start));
            }
        }
        return  sb.toString();
    }
}
