/**
 * 419. 甲板上的战舰
 * 思路：本来以为要dfs,但是这个船只能横着或者竖着，所以都不用dfs,循环就可以标志vis数组
 * O(n2)
 * 1ms 72%
 */
public class class419 {
    boolean[][] vis;
    int cnt = 0;

    public int countBattleships(char[][] board) {
        vis = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (!vis[i][j]) {
                    if (board[i][j] == 'X') {
                        cnt++;
                        DFS(i, j, board);
                    } else {
                        vis[i][j] = true;
                    }
                }
            }
        }
        return cnt;
    }

    void DFS(int i, int j, char[][] board) {

        //竖着有没有战舰
        for (int m = i - 1; m >= 0; m--) {
            if (!vis[m][j] && board[m][j] == 'X') {
                vis[m][j] = true;
            } else {
                break;
            }
        }
        for (int m = i + 1; m < board.length; m++) {
            if (!vis[m][j] && board[m][j] == 'X') {
                vis[m][j] = true;
            } else {
                break;
            }
        }

        //横着有没有战舰
        for (int n = j - 1; n >= 0; n--) {
            if (!vis[i][n] && board[i][n] == 'X') {
                vis[i][n] = true;
            } else {
                break;
            }
        }
        for (int n = j + 1; n < board[0].length; n++) {
            if (!vis[i][n] && board[i][n] == 'X') {
                vis[i][n] = true;
            } else {
                break;
            }
        }
    }
}
