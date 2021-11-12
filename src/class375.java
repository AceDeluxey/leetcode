/**
    375. 猜数字大小 II
 *  DFS 思路还是比较值得看一看
 *  45ms 9.2%
 */
public class class375 {
    //am l r 代表猜的值范围在l和r之间，作出最佳决策，但运气最差时花的钱
    int am [][] = new int [210][210];
    public int getMoneyAmount(int n) {
        return DFS(1,n);
    }
    private int  DFS(int l , int r){
        //得到结果，不需要再选了
        if(l>=r){
            return 0;
        }
        if(am[l][r]!=0){
            return  am[l][r];
        }
        int res = Integer.MAX_VALUE;
        for( int i = l;i < r; i++){
            //代表这一次选i错了后，最差需要多少钱才能获得结果；
            int temp = Math.max(DFS(l,i-1),DFS(i+1,r))+i;
            res = Math.min(temp, res);
        }
        am[l][r] = res;
        return res;
    }
}
