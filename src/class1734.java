/*
    1734. 解码异或后的排列
   给你一个整给你一个整数数组 perm ，它是前 n 个正整数的排列，且 n 是个 奇数 。
   它被加密成另一个长度为 n - 1 的整数数组 encoded ，满足 encoded[i] = perm[i] XOR perm[i + 1] 。
   比方说，如果 perm = [1,3,2] ，那么 encoded = [2,1] 。 给你 encoded 数组，请你返回原始数组 perm 。
   题目保证答案存在且唯一。数数组 perm ，它是前 n 个正整数的排列，且 n 是个 奇数 。 它被加密成另一个长度为 n - 1 的整数数组 encoded ，
   满足 encoded[i] = perm[i] XOR perm[i + 1] 。比方说，如果 perm = [1,3,2] ，那么 encoded = [2,1] 。 给你 encoded 数组，请你返回原始数组 perm 。题目保证答案存在且唯一。


    题目出的不好，题目说“它是前 n 个正整数的排列..."的意思是 ”原数组是 1,2,3,4,5 …… N-1,N 共N个正整数“
    思路：
    看了答案，encoded[0]=an[0]^an[1]; encoded[1]=an[1]^an[2] ... encoded[n-3]=an[n-3]^an[n-2];encoded[n-2]=an[n-2]^an[n-1];
    隔一个^可以求出an[0]^an[1]^an[2]...^an[n-2],因为n为奇数，所以隔一个异或一次不会取到encoded[n-2]=an[n-2]^an[n-1];
    然后an[0]^an[1]; encoded[1]=an[1]^an[n-1]可以求出来，两者异或可以求出an最后一位
    剩下的就如1720，很容易

    3ms 98%
 */
public class class1734 {
    public int[] decode(int[] encoded) {
        //求an[0]^an[1]^an[2]...^an[n-2]
        int len = encoded.length;
        int []an = new int[len+1];
        int temp1=0,temp2=0;
        for(int i=0;i<len;i+=2){
            temp1 ^=encoded[i];
        }
        //求an[0]^an[1]^an[2]...^an[n-1]
        for(int i=1;i<=len+1;i++){
            temp2 ^=i;
        }
        //求an最后一位
        an[len]=temp1^temp2;
        for( int i=len-1; i>=0 ;i--){
            an[i]=an[i+1]^encoded[i];
        }
        return an;
    }
}
