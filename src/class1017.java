/**
 * 1017. 负二进制转换
 * 还是挺奇妙的，总体和正的一样
 * 只不过这个的reminder要用n&1求
 */
public class class1017 {
    public static void main(String[] args) {
        System.out.println(9/-2);
        class1017 test = new class1017();
        test.baseNeg2(2);
    }
    public String baseNeg2(int n) {
        if (n == 0 || n == 1) {
            return String.valueOf(n);
        }
        StringBuilder sb =new StringBuilder();
        while (n != 0) {
            int remainder = n & 1;
            sb.append(remainder);
            n -= remainder;
            n /= -2;
        }


//        while(n!=0){
//            sb.append(n%-2);
//            n = n/-2;
//        }
        return  sb.reverse().toString();
    }
}
