import java.util.Scanner;

public class meituan1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int  n = in.nextInt();
        int  m = in.nextInt();
        int  a = in.nextInt();
        String matrix[][]= new String[n][m];
        for (int i=0;i<n;i++){
            for ( int j =0;j<m;j++){
                matrix [i][j] = in.next();
            }
        }
        int res =0 ;
        for (int i=0;i<n;i++){
            for ( int j =0;j<m;j++){
                int ni = (i+1)%n;
                int nj = (j+1)%m;
                String t1 = matrix[i][j];
                String t2 = matrix[ni][nj];
                for(int k=0;k<a;k++){
                    if (t1.charAt(k)!=t2.charAt(k)){
                        res++;
                    }
                }
            }
        }
        System.out.println(res);
    }

}
