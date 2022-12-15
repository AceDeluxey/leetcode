/**
 *1945. 字符串转化后的各位数字之和
 * 0ms 100%
 */
public class class1945 {
    public int getLucky(String s, int k) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += calEach(s.charAt(i) - 'a'+1);
        }
        k = k - 1;
        for (int i = 0; i < k; i++) {
            sum = calEach(sum);
        }
        return sum;
    }

    private int calEach(int k) {
        int sum = 0;
        while(k!=0){
            sum+=k%10;
            k = k/10;
        }
        return sum;
    }
}
