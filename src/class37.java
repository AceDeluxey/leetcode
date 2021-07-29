import java.util.ArrayList;
import java.util.List;

/**
 * 37.解数独
 */
public class class37 {
    //每一行的Boolean,第一维代表第几行
    boolean rowBoolean[][] = new boolean[9][9];
    //每一列的Boolean，第一维代表第几行
    boolean colBoolean[][] = new boolean[9][9];
    //每一个九宫格的Boolean
    boolean gridBoolean[][][] = new boolean[3][3][9];

    public void solveSudoku(char[][] board) {

        //遍历填充三个boolean数组
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j]!='.'){

                    rowBoolean[i][board[i][j] - '0' - 1] = true;
                    colBoolean[j][board[i][j] - '0' - 1] = true;
                    gridBoolean[i/3][j/3][board[i][j] - '0' - 1] = true;
                }

            }
        }
        fullBoard(0, 0, board);

    }

    private boolean fullBoard(int i, int j, char[][] board) {

//        if(i>8){
//            System.out.println(board);
//            System.out.println(board);
//            return  true;
//        }
        if (board[i][j] == '.') {
            List<Integer> possibleList = findNext(i, j);
            //该位置没有可能的解，返回false
            if (possibleList.size() == 0) {
                return false;
            }

            for (int k = 0; k < possibleList.size(); k++) {
                //设置可能值，并将Boolean值改写
                board[i][j] = (char)(possibleList.get(k)+'0');
                rowBoolean[i][possibleList.get(k)-1]=true;
                colBoolean[i][possibleList.get(k)-1]=true;
                gridBoolean[i/3][j/3][possibleList.get(k)-1]=true;

                //递归调用下一个
                boolean next;
                if (i <= 8) {
                    if (j >= 8) {
                        next = fullBoard(i + 1, 0, board);
                    } else {
                        next = fullBoard(i, j+1, board);
                    }
                } else{

                    next = true;
                }

                //next为tru代表遍历完了,为false说明之后有错，回溯可能值
                if(next){
                    return true;
                } else{
                    //回溯
                    rowBoolean[i][possibleList.get(k)-1]=false;
                    colBoolean[i][possibleList.get(k)-1]=false;
                    gridBoolean[i/3][j/3][possibleList.get(k)-1]=false;
                    board[i][j]='.';
                }

            }
        }
        //board已有的值
        else{
            //直接调用下一个
            boolean next;
            if (i <= 8) {
                if (j >= 8) {
                    next = fullBoard(i + 1, 0, board);
                } else {
                    next = fullBoard(i, j+1, board);
                }
            } else{
                System.out.println(board);
                next = true;
            }
            return next;
        }

        return false;
    }

    private List<Integer> findNext(int i, int j) {
        List<Integer> list = new ArrayList<>();
        for (int k = 0; k < 9; k++) {
            if (!rowBoolean[i][k] && !colBoolean[j][k] && !gridBoolean[i/3][j/3][k]) {
                list.add(k + 1);
            }
        }
        return list;
    }

}
