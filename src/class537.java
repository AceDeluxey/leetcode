/**
 * 537. 复数乘法
 * 5ms 54%
 */

public class class537 {
    public String complexNumberMultiply(String num1, String num2) {
        String[] n1 = num1.split("\\+");
        String[] n2 = num2.split("\\+");
        int n10=Integer.parseInt(n1[0]);
        int n11=Integer.parseInt(n1[1].replace("i",""));
        int n20=Integer.parseInt(n2[0]);
        int n21=Integer.parseInt(n2[1].replace("i",""));

        int shi=n10*n20-n11*n21;
        int xu = n10*n21 + n20*n11;
        return shi+"+"+xu+"i";
    }
}
