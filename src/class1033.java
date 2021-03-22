//1033. 移动石子直到连续
import  java.util.Arrays;
public class class1033 {
    public int[] numMovesStones(int a, int b, int c) {
        int []result =new int [2];
        int []abc=new int [3];
        int max=0;
        int min=0;
        abc[0]=a;
        abc[1]=b;
        abc[2]=c;
        Arrays.sort(abc);
        max=abc[2]-abc[0]-2;
        if(abc[1]-abc[0]==1 && abc[2]-abc[1]==1 ){
            min=0;
        }else if(abc[1]-abc[0]==1 || abc[2]-abc[1]==1 || abc[2]-abc[1]==2||abc[1]-abc[0]==2){
            min=1;
        }else {
            min=2;
        }
        result[0]=min;
        result[1] = max;
        return result;
    }
}
//main
//class1033 test =new class1033();
//
//    int num[]=test.numMovesStones(3,5,1);
//        for (int i:num){
//                System.out.println(i);
//                }