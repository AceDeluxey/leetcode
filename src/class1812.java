/**
 * 1812. 判断国际象棋棋盘中一个格子的颜色
 * 0ms 100
 */
public class class1812 {
    public boolean squareIsWhite(String coordinates) {
        int row = coordinates.charAt(1) - '1';
        int col = coordinates.charAt(0) - 'a';
        if(row%2==0){
            if (col%2==0){
                return false;
            } else{
                return true;
            }
        } else{
            if (col%2==0){
                return true;
            } else{
                return false;
            }

        }
    }
}
