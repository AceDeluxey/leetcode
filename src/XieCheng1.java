import java.util.Scanner;

public class XieCheng1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int [] zeros =  new int [10];
        zeros[0]=1;
        zeros[6]=1;
        zeros[9]=1;
        zeros[8]=2;
        int res =0;
        for ( int i =0 ; i < s.length();i++){
            res +=zeros[s.charAt(i)-'0'];
        }
        System.out.println(res);
    }
}
