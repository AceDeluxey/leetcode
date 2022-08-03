/**
 * 1374. 生成每种字符都是奇数个的字符串
 * 简单的
 */
public class class1374 {
    public String generateTheString(int n) {

        StringBuilder sb = new StringBuilder();
        if(n==0){
            return new String();
        } else if(n==1){
            return "a";
        }
        if (n % 2 == 0) {
            int num = n - 1;
            for (int i = 0; i < num; i++) {
                sb.append('a');
            }
            sb.append('b');
        } else {
            int num = n - 2;
            for (int i = 0; i < num; i++) {
                sb.append('a');
            }
            sb.append('b');
            sb.append('c');
        }
        return sb.toString();
    }
}
