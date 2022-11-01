import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class huawei2 {
    public static void main(String[] args) {
        // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
        // please finish the function body here.
        // please define the JAVA output here. For example: System.out.println(s.nextInt());
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        Set<Integer> set = new HashSet<>();
        for(int i =0 ; i<m;i++){
            set.add(s.nextInt());
        }
        int multi=1;
        while(true){
            boolean flag = true;
            int num = multi*n;
            if(num<0){
                System.out.println(0);
            }
            int temp = num;
            while(temp!=0){
                int ge = temp%10;
                if(!set.contains(ge)){
                    flag = false;
                    break;
                }
                temp = temp/10;
            }
            if(flag){
                System.out.println(temp);
                break;
            } else{
                flag = true;
            }
            multi++;
        }
    }
}
