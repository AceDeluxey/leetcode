/**
 * 791. 自定义字符串排序
 * 简单 就用数组记录字母出现情况就可以了
 * On
 * 0ms 100%
 */
public class class791 {
    public String customSortString(String order, String s) {
        boolean isOrder [] = new boolean[26];
        for (int i =0 ; i<order.length();i++){
            isOrder[order.charAt(i)-'a'] = true;
        }
        int [] map = new int [26];
        StringBuffer sb = new StringBuffer();
        for(int i =0 ; i <s.length();i++){
            int index = s.charAt(i)-'a';
            if(isOrder[index]){
                map[index] ++;
            } else{
                sb.append(s.charAt(i));
            }
        }
        for (int i =0 ; i<order.length();i++){
            char c = order.charAt(i);
            for( int j =0 ;j<map[c-'a'];j++){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
