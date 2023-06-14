/**
 * 1375. 二进制字符串前缀一致的次数
 * 模拟
 * 写完才发现好像只用记录max就行了，因为max》=i+1，说明左边有0
 * max = i+1 说明刚好是满足的
 *
 * On 3ms 27
 */
public class class1375 {
    public int numTimesAllBlue(int[] flips) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        int res =0 ;
        for (int i = 0; i < flips.length; i++) {

            int index = flips[i];
            min = Math.min(min,index);
            max = Math.max(max,index);
            if(min==0){
                if(max - min ==i){
                    res ++;
                }
            }
        }
        return res;
    }
}
