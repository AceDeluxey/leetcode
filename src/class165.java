/**
    165. 比较版本号
    比较简单 2ms 10.56%
 */
public class class165 {
    public int compareVersion(String version1, String version2) {
        String [] sa1 = version1.split("\\.");
        String [] sa2 = version2.split("\\.");
        for(int i = 0; i < Math.max(sa1.length, sa2.length); i++){
            //取version1的一个
            String a1 = i < sa1.length ? sa1[i] : "0";
            //取version2的一个
            String a2 = i < sa2.length ? sa2[i] : "0";
            if(Integer.valueOf(a1)>Integer.valueOf(a2)){
                return 1;
            } else if(Integer.valueOf(a1)<Integer.valueOf(a2)){
                return - 1;
            }
        }
        return 0;
    }
}
