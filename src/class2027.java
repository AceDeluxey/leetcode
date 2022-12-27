/**
 * 2027. 转换字符串的最少操作次数
 * 就是贪心，遇到x从x的下一位开始变最少
 * 比如XXXXXX，肯定是从1和4变最少只用两次，
 * 1ms 80%
 */
public class class2027 {
    public int minimumMoves(String s) {
        int cnt =0;
        int index=0;
        while(index<s.length()){
            if(s.charAt(index)=='X'){
                index+=3;
                cnt+=1;
            }else{
                index+=1;
            }
        }
        return cnt;
    }
}
