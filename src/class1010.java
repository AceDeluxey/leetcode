/**
 * 1010. 总持续时间可被 60 整除的歌曲
 * 2ms 79%
 */
public class class1010 {
    public int numPairsDivisibleBy60(int[] time) {
        int cnt [] = new int [60];
        int res =0 ;
        for (int i : time) {
            int temp = i % 60;
            if(temp ==0){
                res += cnt[0];
            } else{
                res += cnt[60 -temp];
            }

            cnt [temp]++;
        }
        return res;
    }
}
