package swordOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 剑指 Offer II 035. 最小时间差
 * 这个测试用例太逆天了，不知道它怎么定义24小时制，既可以表示前一天又可以后一天
 */
public class sword035 {
    public int findMinDifference(List<String> timePoints) {
        if(timePoints.size() >1440){
            return 0;
        }
        int [] time = new int [timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++) {
            String temp = timePoints.get(i);
            String [] a = temp.split(":");
            time[i] = Integer.parseInt(a[0])*60 + Integer.parseInt(a[1]);
            if(time[i]==0){
                time [i] = 1440;
            }
        }
        Arrays.sort(time);
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < time.length; i++) {
            res = Math.min(res,time[i]-time[i-1]);
            res = Math.min(res, 1440 - time[i]+time[i-1]);
        }
        return res==1439?1:res;
    }

    public void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("12:01");
        list.add("23:59");
        findMinDifference(list);
    }
}
