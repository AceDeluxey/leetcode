import java.util.Scanner;

public class meituan3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int  n = in.nextInt();
        int m = in.nextInt();
        int s = in.nextInt();
        int res =0 ;
        int k =0;
        for ( ;k<n/m;k++){
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int i =0 ; i<m;i++){
                int temp =in.nextInt();
                max = Math.max(max,temp);
                min = Math.min(min,temp);
            }
            res+= m*((max+min)/2)+s;
        }
        int cnt =0 ;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i =0 ; i<n-k*m;i++){
            int temp =in.nextInt();
            max = Math.max(max,temp);
            min = Math.min(min,temp);
            cnt++;
        }
        res+=cnt*((max+min)/2)+s;
        System.out.println(res);
    }
}
