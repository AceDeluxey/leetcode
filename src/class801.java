/**
 * 801. 使序列递增的最小交换次数
 */

public class class801 {
    public int minSwap(int[] A, int[] B) {
        if(A.length==0 || A.length==1){
            return 0;
        }
        int dp=0;

        for(int i=1;i<A.length;i++){
            if(A[i]<=A[i-1] || B[i]<=B[i-1] ){
                A[i]=A[i]+B[i];
                B[i]=A[i]-B[i];
                A[i]=A[i]-B[i];
                dp++;
            }
        }
//        for(int i=A.length-1;i>0;i--){
//            if(A[i]<=A[i-1] || B[i]<=B[i-1] ){
//                A[i]=A[i]+B[i];
//                B[i]=A[i]-B[i];
//                A[i]=A[i]-B[i];
//                dp2++;
//            }
//        }
        return dp;
    }
}
