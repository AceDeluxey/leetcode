/**
 97. 交错字符串
    思路：双指针不行，因为有栈一样的结构，无法在body里决定先看s1还是s2，最终就可能走不出来
            比如 "aabcc"
                "dbbca"
                "aadbbcbcac"

        还得用dp,dp[i][j]的意思是，取s1前i个和s2的前j个，看看能不能合成，
            对于[i][j]可能是，i个元素相等，然后看[i-1][j]；
            也可能是第j个相等，看[i][j-1]
        换言之就是，dp把所有情况遍历了，每一步是取s1的还是s2的都试过了
        而双指针每一步只能取一种，就沿着一种走下去了，不一定能获得最终结果

        思路 On2 7ms 25%

 */
public class class97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length();
        int l2 = s2.length();
        int l3 = s3.length();
        if(l1+l2!=l3){
            return  false;
        }
        boolean dp [][] = new boolean[l1+1][l2+1];
        dp[0][0] = true;

        for( int i = 0; i <= l1; i++){
            for (int j = 0; j <= l2; j++) {
                if( j>0 && s2.charAt(j-1)==s3.charAt(i+j-1) ){
                    dp[i][j]= dp[i][j-1];
                }
                if(i>0 && s1.charAt(i-1)==s3.charAt(i+j-1)){
                    if(!dp[i][j]){
                        dp[i][j]= dp[i-1][j] ;
                    }
                }
            }
        }
        return dp[l1][l2];
        //双指针不行
//        int l1 = s1.length();
//        int l2 = s2.length();
//        int l3 = s3.length();
//        if(l1+l2!=l3){
//            return  false;
//        }
//        int index1 =0, index2 =0;
//        for( int i = 0; i <s3.length(); i++){
//            if(index1<l1 && s1.charAt(index1)==s3.charAt(i)){
//                index1++;
//            } else if(index2<l2 && s2.charAt(index2)==s3.charAt(i)){
//                index2++;
//            } else{
//                return false;
//            }
//        }
//        return index1 == l1-1 && index2 == l2-1;
    }
}
