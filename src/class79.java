/**
 * 79. 单词搜索
 * 给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
    思路:DFS +回溯
        首先二重遍历找到第一个字符的row和col,然后进入DFS搜索
        先是想的单纯的DFS，但这样因为要遍历四个方向，那么必然可能出现遍历回到原点的情况
        参考了答案普遍使用visit数组，如果遍历过就设置状态，这样就不会遍历回去
        但是看到一种很巧妙的方法。就是在DFS里，遍历一个坐标的四周时，先将该点置为#，这样遍历出去就算再遍历回来也会是false，还能节省空间
        递归的思路就是先DFS到底看底部是否满足，再从下到上，每个点只要四个里有一个true就代表该点符合，这样最后退回起点有一个boolean
        69ms 45.9%; 87%
 */
public class class79 {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++){
            for(int j=0;j < board[0].length;j++){
                if(board[i][j] == (word.charAt(0))){
                    if(word.length() == 1){
                        return true;
                    } else{
                        if(search(board, i, j, word,0)){  //找到第一个字符
                            return (true);
                        }
                    }
                }
            }
        }
        return false;
    }
    public boolean search(char[][] board, int row, int col ,String word ,int index){
        if(index== word.length()){
            return true;
        }

        if(row <0 || col <0 || row >=board.length || col >=board[0].length  || board[row][col] != word.charAt(index)){
            return false;
        }
        char temp=board[row][col];
        board[row][col]='#';
        boolean up=search(board, row-1, col,  word ,index+1);
        boolean down=search(board, row+1, col, word ,index+1);
        boolean left=search(board, row, col-1, word ,index+1);
        boolean right=search(board, row, col+1, word ,index+1);
        board[row][col]=temp;
        return up || down || left || right;
    }
}
