/**
 * 2437. 有效时间的数目
 * 模拟 是最快的
 * 虽然可以遍历啥的
 * 但是肯定没有这个快
 */
public class class2437 {
    public int countTime(String time) {
        String[] two = time.split(":");
        int res  =1 ;
        String hour = two[0];
        if(hour.charAt(0)=='?'){
            if(hour.charAt(1)=='?'){
                res *= 24;
            } else{
                if(hour.charAt(1)-'0'>=4){
                    res *= 2;
                } else{
                    res *= 3;
                }

            }
        } else{
            if(hour.charAt(0)-'0'==2){
                res *= 4;
            } else{
                res *=10;
            }
        }
        String mi = two[1];
        if(mi.charAt(0)=='?'){
            if(mi.charAt(1)=='?'){
                res *= 60;
            } else{

                res *=10;
            }
        } else if(mi.charAt(1)=='?'){
            res *=10;
        }
        return res;
    }
}
