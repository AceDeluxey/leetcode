import java.util.Arrays;

/**
 * 1652. 拆炸弹
 * 就是前缀和 模拟一下就行了
 * O2n 0ms 100%
 */
public class class1652 {
    public int[] decrypt(int[] code, int k) {
        if(k==0){
            Arrays.fill(code,0);
            return code;
        }
        int n  = code.length;
        int [] sum = new int [n];
        for(int i =0 ; i < code.length;i++){
            if(i==0){
                sum[i] = code[i];
            } else{
                sum[i] = sum[i-1]+ code[i];
            }
        }
        if(k>0){
            for(int i = 0 ; i<n;i++){
                if(i+k<n){
                    code[i]= sum[i+k]-sum[i];
                } else{
                    code[i] = sum[n-1]-sum[i] + sum[i+k-n];
                }
            }
        } else{
            for(int i = 0 ; i<n;i++){
                if(i+k>0){
                    code[i]= sum[i-1]-sum[i+k-1];
                } else if (i+k==0){
                    code[i]= sum[i-1];
                }
                else{
                    code[i] = sum[i]-code[i] + sum[n-1] - sum[i+k+n-1];
                }
            }
        }
        return code;
    }
}
