import java.util.ArrayList;
import java.util.List;

/*
    212. 单词搜索 II

    思路：暴力dfs，超时
 */
public class class212 {
    List<String> result = new ArrayList<>();
    boolean[][] visited ;
    public List<String> findWords(char[][] board, String[] words) {
        visited = new boolean[board.length][board[0].length];
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                DFS(x, y, board, words, "");
            }
        }
        return result;
    }

    private void DFS(int x, int y, char[][] board, String[] words, String temp) {


        if(x<0 || y<0 || x>= board.length || y>= board[0].length || visited[x][y]){
            return;
        }

        //访问
        visited[x][y] = true;

        String s = temp + board[x][y];

        for (int i = 0; i < words.length; i++) {

            if (s.equals(words[i])) {
                if(!result.contains(s)){
                    result.add(s);
                }
            }
        }

        DFS(x + 1, y, board, words,s);
        DFS(x , y+1, board, words,s);
        DFS(x-1, y, board, words,s);
        DFS(x, y-1, board, words,s);
        //回溯
        visited[x][y] = false;
    }
}
