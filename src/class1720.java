    /*
        1720. 解码异或后的数组
            就很简单
            java的^是按位异或运算，每一位都异或
            1和2异或成为3，3和2又会异或成1
        2ms 73%;
     */
public class class1720 {
    public int[] decode(int[] encoded, int first) {
        int []arr = new int [encoded.length+1];
        arr[0]=first;
        for(int i = 1; i < encoded.length+1; i++){
            arr[i]=arr[i-1]^encoded[i-1];
        }
        return arr;
    }
}
