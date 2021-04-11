/*
    6. Z 字形变换
    将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。

    思路:无脑暴力的，把字符串放到数组中，再读了一遍
    31ms 12.4%; 38.8M 72.66%
 */
public class class6 {
    public String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        int numCols = s.length()/(2*numRows-2)*(numRows-1);
        if(s.length()%(2*numRows-2) > 0){
            if(s.length()%(2*numRows-2) <= numRows){
                numCols++;
            } else{
                numCols+=1+s.length()%(2*numRows-2)-numRows;
            }
        }
        char [][] temp=new char[numRows][numCols];
        int len=s.length();
        int j=0;
        int index=0;
        while(true){
            int i;
            for(i=0;i<numRows && index < len;i++,index++){
                temp[i][j]=s.charAt(index);
            }
            j++;
            for(i-=2;i>=1 && index < len;i--,j++,index++){
                temp[i][j]=s.charAt(index);
            }
            if(index == len){
                break;
            }
        }
        StringBuffer buf = new StringBuffer();
        for(int i=0;i<numRows; i++){
            for (j = 0; j < numCols; j++) {
                if(temp[i][j] != '\0'){
                    buf.append(temp[i][j] );
                }
            }
        }
        return buf.toString();
    }
}
