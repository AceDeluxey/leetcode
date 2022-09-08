/**
 * 667. 优美的排列 II
 * 找规律的题 没啥太大意义
 */
public class class667 {
    public int[] constructArray(int n, int k) {
        int [] res = new int[n];
        int index=0;
        int start =  1;
        int end = n;
        while(index<k+1){
            if(index%2==0){
                res[index++] = start++;
            } else{
                res[index++] = end--;
            }
        }
        if(index%2==0){

            while(index<n){
                res[index++] = start++;
            }
        } else{

            while(index<n){
                res[index++] = end++;
            }
        }

        return res;
    }
}
