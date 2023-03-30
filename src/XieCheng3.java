import java.util.Scanner;

public class XieCheng3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int  n = in.nextInt();

        long res [] = new long [2];
        long mul =1;
        long min = Integer.MAX_VALUE;

        for( long x = 1;x<=100 ;x++){
            mul = mul*x;
            if(x==2){
                continue;
            }
            for (long y=1;y<=5000;y++ ){
                if(x==2){
                    continue;
                }
                long temp = mul*y-y-n;
                if (temp<0){
                    temp = -1*temp;
                }
                if(temp<min){
                    min = temp;
                    res[0]=x;
                    res[1]=y;
                }
            }
        }

        for (int i =0 ; i < res.length;i++){
            System.out.print(res[i]);
            System.out.print(' ');
        }
    }
}
