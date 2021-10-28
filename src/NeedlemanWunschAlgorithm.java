import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Reference:https://zhuanlan.zhihu.com/p/54142276
 */
public class NeedlemanWunschAlgorithm {
    int dp[][];
    String s1;
    String s2;
    List<List<String>> result;

    public int calScore(String s1, String s2) {
        result = new ArrayList<>();
        this.s1 = s1;
        this.s2 = s2;

        //Initialize score matrix
        dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            dp[i][0] = -1 * i;
        }
        for (int i = 0; i <= s2.length(); i++) {
            dp[0][i] = -1 * i;
        }

        //Needleman Wunsch
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    //Two characters are equal
                    dp[i][j] = Math.max(Math.max(dp[i - 1][j] - 1, dp[i][j - 1] - 1), dp[i - 1][j - 1] + 1);
                } else {
                    dp[i][j] = Math.max(Math.max(dp[i - 1][j] - 1, dp[i][j - 1] - 1), dp[i - 1][j - 1] - 1);
                }
            }
        }

        //DFS
        dfsPath(s1.length(), s2.length(), "", "", 0);
        dfsPath(s1.length(), s2.length(), "", "", 1);
        dfsPath(s1.length(), s2.length(), "", "", 2);

        //print probable answer
        for (List<String> temp : result) {
            if(verScore(temp.get(0),temp.get(1))==dp[s1.length()][s2.length()]){
                System.out.println(temp.get(0));
                System.out.println(temp.get(1));
                System.out.println("");
            }
            System.out.println(temp.get(0));
            System.out.println(temp.get(1));
            System.out.println("");
        }
        return dp[s1.length()][s2.length()];
    }

    /**
     * Backtracking to get the best path
     *
     * @param i x axel
     * @param j y axel
     */
    private void dfsPath(int i, int j, String ss1, String ss2, int flag) {


        //finish DFS
        if (i == 0 || j == 0) {
            //add available answer to list
            List<String> temp = new LinkedList<>();
            //reverse the sequence
            StringBuilder a = new StringBuilder(ss1);
            temp.add(a.reverse().toString());

            StringBuilder b = new StringBuilder(ss2);
            temp.add(b.reverse().toString());

            if (temp != null) {
                result.add(temp);
            }

            return;
        }


        //flag =0, no '-' ; flag = 1 , ss1 +'-'; flag =2  ss2 + '-';
        // ss1 represents a vertical sequence,ss2 is horizontal seq
        if (flag == 0) {
            ss1 += s1.charAt(i - 1);
            ss2 += s2.charAt(j - 1);
        } else if (flag == 1) {
            ss1 += '-';
            ss2 += s2.charAt(j - 1);
        } else if (flag == 2) {
            ss1 += s1.charAt(i - 1);
            ss2 += '-';
        }


        //find the max value
        int max = Math.max(dp[i - 1][j], Math.max(dp[i - 1][j - 1], dp[i][j - 1]));
//        if (s1.charAt(i - 1) == 'A' && s2.charAt(j - 1) == 'A') {
//            System.out.println(max);
//            System.out.println(dp[i - 1][j]);
//            System.out.println(dp[i - 1][j - 1]);
//            System.out.println(dp[i][j - 1]);
//            System.out.println(s1.charAt(i - 1));
//            System.out.println(s2.charAt(j - 1));
//            System.out.println("");
//        }
        if (dp[i - 1][j - 1] == max) {
            dfsPath(i - 1, j - 1, ss1, ss2, 0);
        }
        if (dp[i][j - 1] == max) {
            dfsPath(i, j - 1, ss1, ss2, 1);
        }
        if (dp[i - 1][j] == max) {
            dfsPath(i - 1, j, ss1, ss2, 2);
        }
    }

    /**
     * verify the score of two string
     * @param s1
     * @param s2
     * @return
     */
    private int verScore(String s1, String s2) {
        int score = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                score++;
            } else {
                score--;
            }
        }
        return score;
    }
}
