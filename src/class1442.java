/*
    1442. 形成两个异或相等数组的三元组数目
    给你一个整数数组 arr 。
    现需要从数组中取三个下标 i、j 和 k ，其中 (0 <= i < j <= k < arr.length) 。

    思路：我的做法是每求一次异或数组，都把它记下来
         更长或更短的异或数组可以由这个数组异或而来
         但是还是很慢 191ms 5%
     但是看答案，好像只有 dp[start][end]=dp[start][end-1]^arr[end];一种情况
        而且是先遍历算完xor再比较，会快一点29ms 22%
      但还是On3
 */
public class class1442 {
    int [][] dp;
    public int countTriplets(int[] arr) {
        int len= arr.length;
        dp = new int [len][len];
        int cnt=0;
        for(int i=0;i<len-1;i++){
            for( int j=i+1 ; j<len ;j++){
                for( int k=j ; k<len ;k++){
                    //由于题目中a b前后结构不同，所以传参药有所变化，calXOR中计算的是arr[i] ^ arr[i + 1] ^ ... ^ arr[j ]
                    if(calXOR(arr,i,j-1)==calXOR(arr,j,k)){
//                        System.out.print(i);
//                        System.out.print(j);
//                        System.out.println(k);
                        cnt ++;
                    }
                }
            }
        }
        return cnt;
    }
    private int  calXOR(int[] arr,int start , int end){
        if(dp[start][end]!=0){
            return dp[start][end];
        }

        //有更称的异或数组
        if (start-1>=0){
            if(dp[start-1][end]!=0){
                dp[start][end]=dp[start-1][end]^arr[start-1];
                return dp[start][end];
            }
        }
        if(end+1<arr.length){
            if(dp[start][end+1]!=0){
                dp[start][end]=dp[start][end+1]^arr[end+1];
                return dp[start][end];
            }
        }

        //有更短的异或数组
        if(start+1<arr.length){
            if(dp[start+1][end]!=0){
                dp[start][end]=dp[start+1][end]^arr[start];
                return dp[start][end];
            }
        }
        if( end -1 >=0){
            if(dp[start][end-1]!=0){
                dp[start][end]=dp[start][end-1]^arr[end];
                return dp[start][end];
            }
        }


        //没有搜索到就算
        for(int i=start ;i<=end ;i++){
            dp[start][end] ^=arr[i];
        }
        return dp[start][end];
    }

}
