public class ElGamal {
    public static void main(String[] args) {
        System.out.println(calExp(7,4,23));
    }

    public static int  calExp(int a, int b, int p){
        int X=0;
        int temp = 1;
        int cnt = 0;
        while (temp>0){
            temp = temp*a % p;
            cnt++;
            if(temp == b){
                X = cnt;
                break;
            }
        }
        return X;
    }
}
