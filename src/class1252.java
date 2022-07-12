/**
 * 1252. 奇数值单元格的数目
 * 就简单的on2 记录每一行每一列加的次数就可以
 * 0ms 100%
 */
public class class1252 {
    public int oddCells(int m, int n, int[][] indices) {
        int [] row = new int [m];
        int [] col = new int [n];
        for(int [] temp :indices){
            row[temp[0]]++;
            col[temp[1]]++;
        }
        int res = 0;
        for( int i =0 ; i < m ;i++){
            for (int j = 0; j < n; j++) {
                int val = row[i]+col[j];
                if(val%2==1){
                    res++;
                }
            }
        }
        return res;
    }
}
