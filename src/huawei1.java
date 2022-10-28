import java.util.Scanner;

public class huawei1 {
    public static void main(String[] args) {
        // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
        // please finish the function body here.
        // please define the JAVA output here. For example: System.out.println(s.nextInt());
        Scanner s = new Scanner(System.in);
        int N= s.nextInt();
        N=N*2;
        //警察
        int n = s.nextInt();
        n=2*(n-1)+1;
        //小偷
        int m = s.nextInt();
        m=2*(m-1)+1;
        int mstart = m;
        int lun =1;
        int res =0 ;
        boolean flag =false;
        while(true){
            if(!flag){
                if(lun%2==1){
                    m = (m+1)%N;
                } else{
                    m = (m+2)%N;
                }
                if(m==mstart){
                    flag = true;
                }
            } else{
                flag = false;
            }

            n = (n+2)%N;
            res++;
            if(n==m){
                break;
            }
            lun++;
        }

        System.out.println(res);
    }
}
