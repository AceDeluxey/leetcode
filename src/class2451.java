import java.util.List;

/**
 * 2451. 差值数组不同的字符串
 * 其实很简单 就是有点烦
 * 0sm 100
 * 我这样写当然是最快的
 * 可以用map，把这个数组转化成一个字符串之类的
 * 但是肯定慢了很多
 */
public class class2451 {
    public static void main(String[] args) {
        class2451 test = new class2451();
        String[] a = {"adc","wzy","abc"};
        test.oddString(a);
    }
    public String oddString(String[] words) {
        int n = words[0].length();
        int []temp = getNumbers(words);
        for(int i=0;i< words.length;i++){
            String a = words[i];
            for( int j=1;j<n;j++){
                if(a.charAt(j) - a.charAt(j-1)!=temp[j-1]){
                    return a;
                }
            }
        }
        return "";
    }
    private int [] getNumbers(String[] words){
        int n = words[0].length();
        int []a =  new int [n-1];
        int []b =  new int [n-1];
        int []c =  new int [n-1];
        String a1 = words[0];
        String b1 = words[1];
        String c1 = words[2];
        for( int i=1;i<n;i++){

            a[i-1] = a1.charAt(i) - a1.charAt(i-1);
            b[i-1] = b1.charAt(i) - b1.charAt(i-1);
            c[i-1] = c1.charAt(i) - c1.charAt(i-1);
        }
        if(compareTwo(a,b)){
            if(compareTwo(a,c)){
                return a;
            } else{
                return a;
            }
        } else{
            if(compareTwo(a,c)){
                return a;
            } else{
                return c;
            }
        }
    }
    private boolean compareTwo( int a[] , int b[]){
        for(int i =0;i<a.length;i++){
            if (a[i]!=b[i]){
                return false;
            }
        }
        return true;
    }
}
