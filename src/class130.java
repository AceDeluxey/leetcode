/*
        130. 被围绕的区域
        给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的'O' 用 'X' 填充。

        思路：像围棋一样，O如果可以不被围死，必然要相连通向边界
             所以我们在四个边界上使用DFS，将边界上有的O连接起来的O变成# (实际上也是回溯
             剩余的O就一定会被围成X
             我们遍历整个二维数组，将剩余的O变成X
             将#变成O

        2ms 92.4% ; 40M 93%;

 */
public class class130 {
    public void solve(char[][] board) {
        int numRows = board.length;
        int numCols = board[0].length;
        for(int i=0; i< numCols; i++){
            DFS(board, 0, i);
            DFS(board, numRows-1, i);
        }
        for(int i=0; i< numRows; i++){  //遍历两条边，找相连的O
            DFS(board, i, 0);
            DFS(board, i, numCols-1);
        }
        for(int i=0;i<numRows;i++){   //将剩余的#变成O，O变成X
            for(int j=0;j<numCols;j++){
                if(board[i][j] == 'O'){
                    board[i][j]='X';
                }
                if(board[i][j] == '#'){
                    board[i][j]='O';
                }
            }
        }

    }
    public void DFS(char[][] board, int row, int col) {
        if(row<0 || row> board.length-1 || col < 0  || col > board[0].length-1 ){
            return;
        }
        if (board[row][col] == 'O') {  //如果是O，继续找相连的O
            board[row][col] = '#';
            DFS(board,row+1, col);
            DFS(board,row-1, col);
            DFS(board,row, col+1);
            DFS(board,row, col-1);
        }
    }
}
