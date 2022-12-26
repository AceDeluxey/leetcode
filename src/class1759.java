/**
 * 1759. 统计同构子字符串的数目
 *
 * 8ms 86% 模拟
 */
public class class1759 {
    public static void main(String[] args) {
        String a = "abbcccaa";
        class1759 test = new class1759();
        test.countHomogenous(a);
    }
    public int countHomogenous(String s) {
        int MOD = 1000000007;
        int len =s.length();
        long res = 0;
        int index = 0;
        int cnt=0;
        while (index < len) {
            int temp = index;
            while(index<len-1 && s.charAt(index)==s.charAt(index+1)){
                index++;
            }
            cnt = index-temp+1;
            res +=(long)(1+cnt)*cnt/2;
            index++;
        }
//        res +=(long)(1+cnt)*cnt/2;
        return (int)(res%MOD);
    }
}
