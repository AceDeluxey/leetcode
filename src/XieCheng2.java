import java.util.Scanner;

public class XieCheng2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int  n = in.nextInt();
        int k = in.nextInt();
//        boolean visited [] = new boolean[n+1];
        int max = n;
        int re [] = new int [n];
        for( int i = 2*(k-1);i>=0;i-=2){
            re[i]= max;
            max -=1;
//            visited[max] = true;
//            max -=1;
        }
        int index =1;
        for (int i =0;i<n;i++) {
            if (re[i]==0){
                re[i] = index++;
            }
        }
        for (int i =0 ; i < re.length;i++){
            System.out.print(re[i]);
            System.out.print(' ');
        }


    }
}
