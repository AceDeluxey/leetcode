import java.util.ArrayList;
import java.util.List;

/**
    401. 二进制手表
    二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。每个 LED 代表一个 0 或 1，最低位在右侧。

    思路：学到了bitCount函数，数二进制数的1的个数；加起来看是否等于turnedOn就行了
        O（12*60)
    12ms 35%

 */

public class class401 {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> list = new ArrayList<>();
        for( int h=0 ; h <12 ; h++){
            for( int m=0; m<60 ; m++){
                if(Integer.bitCount(h)+Integer.bitCount(m)==turnedOn){
                    list.add(Integer.toString(h)+":"+(m<10?"0" : "")+Integer.toString(m));
                }
            }
        }
        return list;
    }
}
