package LCP;

import java.util.Arrays;

/**
 * LCP 33. 蓄水
 * 就是在蓄水之前要先加桶的容量
 * 枚举的时候，枚举的是总共蓄水几次
 * 还是有点巧妙的
 * 207ms 9.2
 */
public class LCP33 {
    public int storeWater(int[] bucket, int[] vat) {
        int max = Arrays.stream(vat).max().getAsInt();
        if (max == 0) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= max; i++) {
            int tmp = 0;
            //加水桶容量的次数
            for (int j = 0; j < vat.length; j++) {
                //预计要用的
                int pre = (int) Math.ceil((double) vat[j]/(double) i);
                if(pre > bucket[j]){
                    tmp += pre - bucket[j];
                }
            }
            //打水的次数
            tmp += i;
            res = Math.min(res,tmp);
        }
        return res;
    }
}
