/**
 * 997. 找到小镇的法官
 *
 * 思路：在循环trust里找出不相信别人的人，和每个人的票数
        然后再循环找出不相信别人的人里面票数为n-1的人
        那么因为要循环第二次n,所以可以用boolean数组记录他是否相信人

    O(n+trust.length) , 2ms 98.3%
 */
public class class997 {
    public int findJudge(int n, int[][] trust) {
        boolean[] isTrust = new boolean[n];
        int[] amount = new int[n];
        for (int i = 0; i < trust.length; i++) {
            // 这个人相信了别人
            isTrust[trust[i][0] - 1] = true;
            // 别人相信了这个人
            amount[trust[i][1] - 1]++;
        }

        //不相信别人的人里，得票为N-1的人是法官
        int res = -1;
        for (int i = 0; i < n; i++) {
            if (!isTrust[i]) {
                if (amount[i] == n - 1) {
                    res = i + 1;
                    break;
                }
            }
        }
        return res;
    }
}
